package com.thigas.quack.application.service;

import com.github.javafaker.Faker;
import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.mapper.AchievementMapper;
import com.thigas.quack.adapter.mapper.AddressMapper;
import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.adapter.mapper.StepMapper;
import com.thigas.quack.adapter.mapper.TaskMapper;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FakerService {

	private final Faker faker = new Faker();
	private final UserMapper userMapper = UserMapper.INSTANCE;
	private final RoadmapMapper roadmapMapper = RoadmapMapper.INSTANCE;
	private final AddressMapper addressMapper = AddressMapper.INSTANCE;
	private final StatisticsMapper statisticsMapper = StatisticsMapper.INSTANCE;
	private final AchievementMapper achievementMapper = AchievementMapper.INSTANCE;
	private final StepMapper stepMapper = StepMapper.INSTANCE;
	private final LessonMapper lessonMapper = LessonMapper.INSTANCE;
	private final TaskMapper taskMapper = TaskMapper.INSTANCE;

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

	public List<UserDTO> generateFakeUsers(int count) {
		List<UserDTO> users = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			UserDTO userDTO = new UserDTO();
			userDTO.setName(faker.name().fullName());
			userDTO.setUsername(faker.internet().domainName());
			userDTO.setEmail(faker.internet().emailAddress());
			userDTO.setPhone(faker.phoneNumber().phoneNumber());
			userDTO.setPassword(faker.internet().password());
			userDTO.setCpf(faker.idNumber().valid());
			userDTO.setBornAt(LocalDate.now().toString());
			userDTO.setPoints(faker.number().randomDouble(2, 0, 100));
			userDTO.setRegisterAt(faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toString());
			userDTO.setImagePath(faker.avatar().image());
			userDTO.setStatus(1); // 1 para ATIVO

			// Salvar usuário no banco de dados
			userService.create(userDTO);
			users.add(userDTO);
		}
		return users;
	}

	public List<AddressDTO> generateFakeAddresses(int count, int userId) {
		List<AddressDTO> addresses = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setUserId(userId);
			addressDTO.setStreet(faker.address().streetName());
			addressDTO.setCity(faker.address().city());
			addressDTO.setState(faker.address().state());
			addressDTO.setCountry(faker.address().country());
			addressDTO.setZipCode(faker.address().zipCode());
			addressDTO.setNumber(faker.address().buildingNumber());

			// Salvar endereço no banco de dados
			addressService.create(addressDTO);
			addresses.add(addressDTO);
		}
		return addresses;
	}

	public List<StatisticsDTO> generateFakeStatistics(int count, int userId) {
		List<StatisticsDTO> statisticsList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
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
		for (int i = 0; i < count; i++) {
			AchievementDTO achievementDTO = new AchievementDTO();
			achievementDTO.setName(faker.hacker().verb() + " Achievement");
			achievementDTO.setDescription(faker.lorem().sentence());
			achievementDTO.setImagePath(faker.avatar().image());

			achievementService.create(achievementDTO);

			achievements.add(achievementDTO);
		}
		return achievements;
	}

	public List<RoadmapDTO> generateFakeRoadmaps(int count) {
		List<RoadmapDTO> roadmaps = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			RoadmapDTO roadmapDTO = new RoadmapDTO();
			roadmapDTO.setTitle(faker.book().title());
			roadmapDTO.setDescription(faker.lorem().paragraph());
			roadmapDTO.setImagePath(faker.avatar().image());
			roadmapDTO.setStatus(1); // 1 para ATIVO

			// Salvar roadmap no banco de dados
			roadmapService.create(roadmapDTO);
			roadmaps.add(roadmapDTO);
		}
		return roadmaps;
	}

	public List<StepDTO> generateFakeSteps(int count, Set<Integer> roadmapIds, Set<Integer> lessonIds) {
		List<StepDTO> steps = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			StepDTO stepDTO = new StepDTO();
			stepDTO.setRoadmapIds(roadmapIds);
			stepDTO.setLessonIds(lessonIds);
			stepDTO.setDescription(faker.lorem().sentence());
			stepDTO.setImagePath(faker.avatar().image());
			stepDTO.setStatus(faker.number().numberBetween(0, 3));

			stepService.create(stepDTO);
			steps.add(stepDTO);
		}
		return steps;
	}

	public List<LessonDTO> generateFakeLessons(int count) {
		List<LessonDTO> lessons = new ArrayList<>();
		for (int i = 0; i < count; i++) {
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

	public List<TaskDTO> generateFakeTasks(int count) {
		List<TaskDTO> tasks = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setDescription(faker.lorem().sentence());
			taskDTO.setImagePath(faker.avatar().image());

			// Gerar IDs de lições fictícios (exemplo: de 1 a 10)
			Set<Integer> lessonIds = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toSet());
			taskDTO.setLessonIds(lessonIds);

			// Salvar tarefa no banco de dados
			taskService.create(taskDTO);
			tasks.add(taskDTO);
		}
		return tasks;
	}

	public void generateAllFakeData() {
		int recordCount = 10; // Define o número de registros que você quer criar

		// Gera usuários
		List<UserDTO> users = generateFakeUsers(recordCount);

		// Gera roadmaps
		List<RoadmapDTO> roadmaps = generateFakeRoadmaps(recordCount);

		// Para cada usuário, gera endereços e estatísticas
		for (UserDTO user : users) {
			generateFakeAddresses(1, user.getId()); // Por exemplo, 3 endereços por usuário
			generateFakeStatistics(1, user.getId()); // 1 estatística por usuário
		}

		// Gera conquistas
		List<AchievementDTO> achievements = generateFakeAchievements(recordCount);

		// Gera lições
		List<LessonDTO> lessons = generateFakeLessons(recordCount);

		// Gera etapas
		Set<Integer> roadmapIds = roadmaps.stream().map(RoadmapDTO::getId).collect(Collectors.toSet());
		Set<Integer> lessonIds = lessons.stream().map(LessonDTO::getId).collect(Collectors.toSet());
		List<StepDTO> steps = generateFakeSteps(recordCount, roadmapIds, lessonIds);

		// Gera tarefas
		List<TaskDTO> tasks = generateFakeTasks(recordCount);
	}

}
