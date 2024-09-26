package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.*;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FakerService {

	private final Faker faker = new Faker();

	@Autowired
	private UserService userService;

	@Autowired
	private RoadmapService roadmapService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private StatisticsService statisticsService;

	@Autowired
	private AchievementService achievementService;

	@Autowired
	private StepService stepService;

	@Autowired
	private LessonService lessonService;

	@Autowired
	private TaskService taskService;

	// Geração de usuários
	public List<UserDTO> generateFakeUsers(int count) {
		List<UserDTO> users = new ArrayList<>();
		Set<String> existingEmails = new HashSet<>();
		Set<String> existingUsernames = new HashSet<>();

		for (int i = 1; i <= count; i++) {
			UserDTO userDTO = new UserDTO();
			userDTO.setName(faker.name().fullName());

			String username;
			do {
				username = faker.internet().domainName();
			} while (existingUsernames.contains(username));
			existingUsernames.add(username);
			userDTO.setUsername(username);

			String email;
			do {
				email = faker.internet().emailAddress();
			} while (existingEmails.contains(email));
			existingEmails.add(email);
			userDTO.setEmail(email);

			userDTO.setPhone(faker.phoneNumber().phoneNumber());
			userDTO.setPassword(faker.internet().password());
			userDTO.setCpf(faker.idNumber().valid());
			userDTO.setBornAt(LocalDate.now().toString());
			userDTO.setPoints(faker.number().randomDouble(2, 0, 100));
			userDTO.setRegisterAt(faker.date().past(10, TimeUnit.DAYS).toInstant().atOffset(ZoneOffset.UTC).toString());
			userDTO.setImagePath(faker.avatar().image());
			userDTO.setStatus(1); // 1 para ATIVO

			userDTO = userService.create(userDTO);
			users.add(userDTO);
		}

		// Verificação de IDs
		if (users.isEmpty() || users.stream().anyMatch(user -> user.getId() < 1)) {
			throw new RuntimeException("Invalid users generated.");
		}

		return users;
	}

	public List<AddressDTO> generateFakeAddresses(int count, int userId) {
		List<AddressDTO> addresses = new ArrayList<>();

		// Recupera o usuário com o ID fornecido
		UserDTO userDTO = userService.getById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

		for (int i = 1; i < count + 1; i++) {
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setUserId(userDTO.getId());
			addressDTO.setStreet(faker.address().streetName());
			addressDTO.setCity(faker.address().city());
			addressDTO.setState(faker.address().state());
			addressDTO.setCountry(faker.address().country());
			addressDTO.setZipCode(faker.address().zipCode());
			addressDTO.setNumber(faker.address().buildingNumber());

			addressService.create(addressDTO);
			addresses.add(addressDTO);
		}
		return addresses;
	}

	public List<StatisticsDTO> generateFakeStatistics(int count, int userId) {
		List<StatisticsDTO> statisticsList = new ArrayList<>();
		for (int i = 1; i < count + 1; i++) {
			StatisticsDTO statisticsDTO = new StatisticsDTO();
			statisticsDTO.setUserId(userId);
			statisticsDTO.setStreakDays(faker.number().numberBetween(0, 30));
			statisticsDTO.setBestStreak(faker.number().numberBetween(1, 100));
			statisticsDTO.setUserLevel(faker.number().numberBetween(1, 10));
			statisticsDTO.setUserExperience(faker.number().randomDouble(2, 0, 1000));
			statisticsDTO.setChallengesCompleted(faker.number().numberBetween(0, 50));
			statisticsDTO.setLessonsCompleted(faker.number().numberBetween(0, 100));

			statisticsService.create(statisticsDTO);
			statisticsList.add(statisticsDTO);
		}
		return statisticsList;
	}

	public List<AchievementDTO> generateFakeAchievements(int count) {
		List<AchievementDTO> achievements = new ArrayList<>();
		for (int i = 1; i <= count + 1; i++) {
			AchievementDTO achievementDTO = new AchievementDTO();
			achievementDTO.setName(faker.hacker().verb() + " Achievement");
			achievementDTO.setDescription(faker.lorem().sentence(5));
			achievementDTO.setImagePath(faker.avatar().image());

			// Não tentar adicionar uma cidade
			achievementService.create(achievementDTO);
			achievements.add(achievementDTO);
		}
		return achievements;
	}

	public List<RoadmapDTO> generateFakeRoadmaps(int count) {
		List<RoadmapDTO> roadmaps = new ArrayList<>();
		for (int i = 1; i < count + 1; i++) {
			RoadmapDTO roadmapDTO = new RoadmapDTO();
			roadmapDTO.setTitle(faker.book().title());
			roadmapDTO.setDescription(faker.lorem().paragraph());
			roadmapDTO.setImagePath(faker.avatar().image());
			roadmapDTO.setStatus(1); // 1 para ATIVO

			roadmapService.create(roadmapDTO);
			roadmaps.add(roadmapDTO);
		}
		return roadmaps;
	}

	public List<LessonDTO> generateFakeLessons(int count) {
		System.out.println("Generating " + count + " lessons...");
		List<LessonDTO> lessons = new ArrayList<>();
		for (int i = 1; i < count + 1; i++) {
			System.out.println("Generating lesson " + i + "...");
			LessonDTO lessonDTO = new LessonDTO();
			lessonDTO.setTitle(faker.educator().course());
			lessonDTO.setDescription(faker.lorem().paragraph());
			lessonDTO.setLanguage(faker.rickAndMorty().character());
			lessonDTO.setImagePath(faker.avatar().image());

			lessonService.create(lessonDTO);
			lessons.add(lessonDTO);
		}
		return lessons;
	}

	private List<StepDTO> generateFakeSteps(int recordCount, Set<Integer> roadmapIds, Set<Integer> lessonIds) {
		System.out.println("Generating " + recordCount + " steps...");
		List<StepDTO> steps = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < recordCount; i++) {
			System.out.println("Generating step " + (i + 1) + "...");
			StepDTO stepDTO = new StepDTO();

			// Atribui um ID de roadmap aleatório
			Integer[] roadmapArray = roadmapIds.toArray(new Integer[0]);
			int randomRoadmapId = roadmapArray[random.nextInt(roadmapArray.length)];
			System.out.println("Random roadmap ID: " + randomRoadmapId);
			Set<Integer> roadmapIdSet = new HashSet<>();
			roadmapIdSet.add(randomRoadmapId);
			stepDTO.setRoadmapIds(roadmapIdSet);

			// Atribui IDs de lições aleatórios
			Set<Integer> lessonIdSet = new HashSet<>();
			if (!lessonIds.isEmpty()) { // Verifica se lessonIds não está vazio
				int randomLessonCount = Math.min(1, lessonIds.size());
				for (int j = 0; j < randomLessonCount; j++) {
					Integer[] lessonArray = lessonIds.toArray(new Integer[0]);
					int randomLessonId = lessonArray[random.nextInt(lessonArray.length)];
					lessonIdSet.add(randomLessonId);
				}
			} else {
				// Lide com o caso em que não há lições disponíveis
				throw new IllegalStateException("No lesson IDs available.");
			}
			stepDTO.setLessonIds(lessonIdSet);

			steps.add(stepDTO);

		}

		return steps;
	}

	public List<TaskDTO> generateFakeTasks(int count) {
		List<TaskDTO> tasks = new ArrayList<>();
		for (int i = 1; i < count + 1; i++) {
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setDescription(faker.lorem().sentence());
			taskDTO.setImagePath(faker.avatar().image());

			Set<Integer> lessonIds = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toSet());
			taskDTO.setLessonIds(lessonIds);

			taskService.create(taskDTO);
			tasks.add(taskDTO);
		}
		return tasks;
	}

	private Integer getRandomElement(Set<Integer> set, Random random) {
		int index = random.nextInt(set.size());
		return set.stream().skip(index).findFirst().orElse(null);
	}

	public void generateAllFakeData(int recordCount) {
		// Gera usuários
		List<UserDTO> users = generateFakeUsers(recordCount);

		// Verifica se os usuários foram gerados corretamente
		if (users.isEmpty() || users.stream().anyMatch(user -> user.getId() < 1)) {
			throw new IllegalStateException("Invalid users generated.");
		}

		// Gera roadmaps
		List<RoadmapDTO> roadmaps = generateFakeRoadmaps(recordCount);
		if (roadmaps.isEmpty()) {
			throw new IllegalStateException("No roadmaps generated.");
		}

		// Gera conquistas
		List<AchievementDTO> achievements = generateFakeAchievements(recordCount);
		if (achievements.isEmpty()) {
			throw new IllegalStateException("No achievements generated.");
		}

		// Gera lições
		List<LessonDTO> lessons = generateFakeLessons(recordCount);
		if (lessons.isEmpty()) {
			throw new IllegalStateException("No lessons generated.");
		}

		// Gera tarefas
		List<TaskDTO> tasks = generateFakeTasks(recordCount);
		if (tasks.isEmpty()) {
			throw new IllegalStateException("No tasks generated.");
		}

		// Gera passos para todos os roadmaps e lições
		Set<Integer> roadmapIds = roadmaps.stream().map(RoadmapDTO::getId).collect(Collectors.toSet());
		Set<Integer> lessonIds = lessons.stream().map(LessonDTO::getId).collect(Collectors.toSet());

		// Gera passos
		List<StepDTO> steps = generateFakeSteps(recordCount, roadmapIds, lessonIds);
		if (steps.isEmpty()) {
			throw new IllegalStateException("No steps generated.");
		}

		// Persistindo os passos
		for (StepDTO step : steps) {
			stepService.create(step); // Certifique-se de que este método não está falhando
		}

		// Para cada usuário, gera endereços e estatísticas
		for (UserDTO user : users) {
			// Verifica se o ID do usuário é válido antes de gerar dados relacionados
			if (user.getId() <= 0) {
				throw new IllegalStateException("Invalid user ID: " + user.getId());
			}

			System.out.println("Generating addresses for user ID: " + user.getId());
			generateFakeAddresses(1, user.getId()); // Ajustado para criar 3 endereços por usuário
			generateFakeStatistics(1, user.getId()); // 1 estatística por usuário
		}

		// Continue com a geração de dados ou finalize
		System.out.println("All fake data generated successfully.");
	}

}
