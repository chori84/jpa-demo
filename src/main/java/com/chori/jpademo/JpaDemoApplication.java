package com.chori.jpademo;

import com.chori.jpademo.model.*;
import com.chori.jpademo.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class JpaDemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(JpaDemoApplication.class);

	@Autowired
	DeptRepository deptRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	AddrRepository addrRepository;

	@Autowired
	SawonRepository sawonRepository;

	@Autowired
	HobbyRepository hobbyRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

//	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Emp e1 = Emp.builder().ename("김교육").build();
		Emp e2 = Emp.builder().ename("나교육").build();

		Dept d1 = Dept.builder().dname("교육팀").emps(new HashSet<Emp>() {
			{
				add(e1);
				add(e2);
			}
		}).build();

		e1.setDept(d1);
		e2.setDept(d1);

		Dept d2 = Dept.builder().dname("개발팀").emps(new HashSet<Emp>() {
			{
				add(Emp.builder().ename("김개발").build());
				add(Emp.builder().ename("나개발").build());
			}
		}).build();

		deptRepository.saveAll(new HashSet<Dept>() {
			{
				add(d1);
				add(d2);
			}
		});

		for (Dept d : deptRepository.findAll()) {
			logger.info(d.toString());
		}

		Dept d3 = deptRepository.findById(d1.getDeptno()).get();
		Set<Emp> emps = d3.getEmps();
		for (Emp e : emps) {
			logger.info(e.toString());
		}

		deptRepository.delete(d3);

		logger.info("================================================================");

		List<Emp> empList = new ArrayList<>();
		empList.add(Emp.builder().ename("김길동").addr(Addr.builder().address("서울").build()).build());
		empList.add(Emp.builder().ename("나길동").addr(Addr.builder().address("제주").build()).build());
		empList.add(Emp.builder().ename("다길동").addr(Addr.builder().address("뉴욕").build()).build());

		empRepository.saveAll(empList);

		for (Emp e : empRepository.findAll()) {
			logger.info(e.toString());
		}

		Addr addr1 = Addr.builder().address("대전").build();
		Emp ea1 = Emp.builder().ename("대전 길동").build();
		ea1.setAddr(addr1);
		empRepository.save(ea1);

		Addr addr2 = Addr.builder().address("하와이").build();
		Emp ea2 = Emp.builder().ename("하와이 길동").build();
		ea2.setAddr(addr2);
		empRepository.save(ea2);

		logger.info("================================================================");

		saveSawonsAndHobbies();
		sawonRepository.flush();
		deleteSawon();
		sawonRepository.flush();
		updateSawon();
		sawonRepository.flush();
		deleteSawonAndHobby();
	}

	private Long sawon1Id;
	private Long sawon2Id;
	private Long hobby1Id;

	private void saveSawonsAndHobbies() {
		Sawon s1 = Sawon.builder().name("1길동").hobbies(new ArrayList<Hobby>() {
			{
				add(Hobby.builder().name("취미1").build());
				add(Hobby.builder().name("취미2").build());
			}
		}).build();

		Sawon s2 = Sawon.builder().name("2길동").hobbies(new ArrayList<Hobby>() {
			{
				add(Hobby.builder().name("취미3").build());
			}
		}).build();

		sawonRepository.saveAll(new HashSet<Sawon>(){
			{
				add(s1);
				add(s2);
			}
		});

		sawon1Id = s1.getId();
		sawon2Id = s2.getId();
		hobby1Id = s1.getHobbies().get(0).getId();

		for (Sawon s : sawonRepository.findAll()) {
			logger.info(s.toString());
		}
	}

	private void deleteSawon() {
		Sawon s2 = sawonRepository.findById(sawon2Id).get();
		logger.info("삭제될 사원 => " + s2.toString());
		sawonRepository.delete(s2);
	}

	private void updateSawon() {
		Sawon s1 = sawonRepository.findById(sawon1Id).get();
		logger.info("수정될 사원 => " + s1.toString());
		s1.getHobbies().add(Hobby.builder().name("취미4").build());
		s1.setName("11길동");
		sawonRepository.save(s1);
	}

	private void deleteSawonAndHobby() {
		Sawon s1 = sawonRepository.findById(sawon1Id).get();
		Hobby h1 = hobbyRepository.findById(hobby1Id).get();

		if(s1.getHobbies().contains(h1)) {
			s1.getHobbies().remove(h1);
		}

		sawonRepository.save(s1);
	}
}
