package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.*;

import com.thigas.quack.infrastructure.persistence.entity.TaskText;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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

	@PersistenceContext
	private EntityManager entityManager;

	// Geração de usuários
	public Set<UserDTO> generateFakeUsers(int count) {
		Set<UserDTO> users = new HashSet<>();
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

	public Set<AddressDTO> generateFakeAddresses(int count, int userId) {
		Set<AddressDTO> addresses = new HashSet<>();

		// Recupera o usuário com o ID fornecido
		UserDTO userDTO = userService.getById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

		for (int i = 1; i < count + 1; i++) {
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setUser(userDTO.getId());
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

	public Set<StatisticsDTO> generateFakeStatistics(int count, int userId) {
		Set<StatisticsDTO> statisticsSet = new HashSet<>();
		for (int i = 1; i < count + 1; i++) {
			StatisticsDTO statisticsDTO = new StatisticsDTO();
			statisticsDTO.setUser(userId);
			statisticsDTO.setStreakDays(faker.number().numberBetween(0, 30));
			statisticsDTO.setBestStreak(faker.number().numberBetween(1, 100));
			statisticsDTO.setUserLevel(faker.number().numberBetween(1, 10));
			statisticsDTO.setUserExperience(faker.number().randomDouble(2, 0, 1000));
			statisticsDTO.setChallengesCompleted(faker.number().numberBetween(0, 50));
			statisticsDTO.setLessonsCompleted(faker.number().numberBetween(0, 100));

			statisticsService.create(statisticsDTO);
			statisticsSet.add(statisticsDTO);
		}
		return statisticsSet;
	}

	public Set<AchievementDTO> generateFakeAchievements(int count) {
		Set<AchievementDTO> achievements = new HashSet<>();
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

	public Set<RoadmapDTO> generateFakeRoadmaps(int count) {
		Set<RoadmapDTO> roadmaps = new HashSet<>();
		for (int i = 1; i <= count; i++) {
			RoadmapDTO roadmapDTO = new RoadmapDTO();
			roadmapDTO.setTitle(faker.book().title());
			roadmapDTO.setDescription(faker.lorem().characters(200));
			roadmapDTO.setImagePath(faker.avatar().image());
			roadmapDTO.setStatus(1); // 1 para ATIVO

			// Persistindo e atualizando o objeto com o retorno
			roadmapDTO = roadmapService.create(roadmapDTO); // Atualize o roadmapDTO com o resultado da persistência

			if (roadmapDTO.getId() <= 0) {
				throw new IllegalStateException("Failed to create roadmap with valid ID.");
			}

			roadmaps.add(roadmapDTO);
		}
		return roadmaps;
	}

	public Set<LessonDTO> generateFakeLessons(int count) {
		Set<LessonDTO> lessons = new HashSet<>();
		for (int i = 1; i <= count; i++) {

			LessonDTO lessonDTO = new LessonDTO();
			lessonDTO.setTitle(faker.educator().course());
			lessonDTO.setDescription(faker.lorem().paragraph());
			lessonDTO.setLanguage(faker.educator().course());
			lessonDTO.setImagePath(faker.avatar().image());

			lessonDTO = lessonService.create(lessonDTO);

			if (lessonDTO.getId() <= 0) {
				throw new IllegalStateException("Failed to create lesson with valid ID.");
			}

			lessons.add(lessonDTO);
		}
		return lessons;
	}

	private Set<Integer> getRandomSubset(Set<Integer> set, int size) {
		if (set.size() <= size) {
			return new HashSet<>(set); // Retorna todo o conjunto se o tamanho for menor ou igual ao solicitado
		}

		List<Integer> list = new ArrayList<>(set); // Converte o Set em uma List
		Collections.shuffle(list); // Embaralha a lista
		return new HashSet<>(list.subList(0, size)); // Retorna um novo Set com o subconjunto
	}

	public Set<TaskDTO> generateFakeTasks(int count) {
		Set<TaskDTO> tasks = new HashSet<>();

		for (int i = 1; i <= count; i++) {
			TaskDTO taskDTO = new TaskDTO();
			TaskText taskText = new TaskText();

			taskText.setTitle(faker.lorem().sentence());
			taskText.setDescription(faker.lorem().paragraph());
			taskText.setText(faker.lorem().paragraph(2));
			taskDTO.setTasktext(taskText);
			taskDTO.setImagePath(faker.avatar().image());
			Set<Integer> steps = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toSet());
			taskDTO.setSteps(steps);

			taskDTO = taskService.create(taskDTO);

			if (taskDTO.getId() <= 0) {
				throw new IllegalStateException("Failed to create task with valid ID.");
			}

			tasks.add(taskDTO);
		}

		return tasks;
	}

    // Método para gerar passos falsos
    public Set<StepDTO> generateFakeSteps(int count, Set<Integer> roadmapIds, Set<Integer> taskIds, Set<Integer> lessonIds) {
        Set<StepDTO> steps = new HashSet<>();
        for (int i = 1; i <= count; i++) {
            StepDTO stepDTO = new StepDTO();
            stepDTO.setDescription("Fake description " + i);
            stepDTO.setImagePath("/fake/images/image" + i + ".jpg");
            stepDTO.setStatus(1);
            steps.add(stepDTO);
        }
        return steps;
    }

	public void generateAllFakeData(int recordCount) {
		// Gera usuários
		Set<UserDTO> users = generateFakeUsers(recordCount);

		// Gera roadmaps
		Set<RoadmapDTO> roadmaps = generateFakeRoadmaps(recordCount);

		// Gera lições
		Set<LessonDTO> lessons = generateFakeLessons(recordCount);

		Set<TaskDTO> tasks = generateFakeTasks(recordCount);

		// Certifique-se de que todos os roadmaps e lessons estão persistidos
		Set<Integer> roadmapsIds = roadmaps.stream().map(RoadmapDTO::getId).collect(Collectors.toSet());
		Set<Integer> lessonsIds = lessons.stream().map(LessonDTO::getId).collect(Collectors.toSet());
		Set<Integer> tasksIds = tasks.stream().map(TaskDTO::getId).collect(Collectors.toSet());

		// Gera passos
		Set<StepDTO> steps = generateFakeSteps(recordCount, roadmapsIds, tasksIds,lessonsIds);
		for (StepDTO step : steps) {
			stepService.create(step);
		}

		// Continue com a geração de dados para endereços e estatísticas
		for (UserDTO user : users) {
			generateFakeAddresses(1, user.getId());
			generateFakeStatistics(1, user.getId());
		}

		System.out.println("All fake data generated successfully.");
	}

}
