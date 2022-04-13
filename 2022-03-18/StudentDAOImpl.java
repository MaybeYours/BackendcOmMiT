package xyz.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.itwill10.dto.Student;
import xyz.itwill10.mapper.StudentMapper;

//SpringMVC���� Mybatis Framework�� ����Ͽ� DAO Ŭ������ �ۼ��ϴ� ���
//1.DataSource ���� ���̺귯���� Mybatis ���� ���̺귯�� ������Ʈ�� ���� ó�� - pom.xml
// => ojdbc, spring-jdbc(spring-tx), mybatis, mybatis-spring
//2.Mybtis Framework�� ȯ�漳������ �ۼ�
//3.DataSource ���� Ŭ����, SqlSessionFactory ���� Ŭ������ SqlSession ���� Ŭ������ Spring Bean���� ���
// => Bean Configuration File(root-context.xml)���� bean ������Ʈ ����Ͽ� Spring Bean���� ���
//4.Table ���� >> DTO Ŭ���� �ۼ�
//5.Mapper �ۼ� - XML ���ۿ� Interface ���۸� ���ε��Ͽ� �ۼ��ϴ� ���� ����
//6.DAO Ŭ���� �ۼ� - XML ���ۿ� ��ϵ� SQL ������ �����Ͽ� �����ϰ� ����� �����޾� ��ȯ

//Mybatis Framework���� �����Ǵ� �α׸� Spring �α� ����ü�� ��ϵǵ��� �����ϴ� ���
//1.log4jdbc-log4j2-jdbc4 ���̺귯���� ������Ʈ�� ���� ó�� - pom.xml
//2.DataSource ���� Ŭ������ Spring Bean���� ����� bean ������Ʈ���� driverClassName �ʵ尪��
//url �ʵ尪�� �����Ͽ� ������ ó�� - root-context.xml
//3.[src/main/resources] ������ [log4jdbc.log4j2.properties] ���� �ۼ�
//4.[src/main/resources] ������ [log4j.xml] ���Ͽ��� �α� �̺�Ʈ�� ���� ��� ����

//DAO Ŭ���� : �����ü���� �࿡ ���� ����,����,����,�˻� ����� �����ϴ� Ŭ����
// => DBMS ������ SQL ������ �����Ͽ� �����ϰ� �������� Java ��ü�� ��ȯ�ϴ� ����� �޼ҵ� �ۼ�

//DAO Ŭ������ Spring Annotation���� Spring Bean���� ��� 
// => Service Ŭ�������� DAO ��ü�� �����޾� �޼ҵ� ȣ���ϱ� ���� Spring Bean���� ���
//@Repository : DAO Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
// => Ʈ������ ������ ���� ����� �����޾� ���
//Spring Container�� Spring Annotation�� ó���ϱ� ���� Bean Configuration File(servlet-context.xml)����
//component-scan ������Ʈ�� ����Ͽ� DAO Ŭ������ �ۼ��� ��Ű���� base-package �Ӽ������� ����
@Repository  
public class StudentDAOImpl implements StudentDAO {
	//SqlSession ���� Ŭ������ Spring Bean�� �����޾� �ʵ忡 ������ ó��
	// => DAO Ŭ������ �޼ҵ忡�� SqlSession ��ü�� �޼ҵ带 ȣ���Ͽ� XML ���� ���Ͽ� ��ϵ�
	//SQL ������ �����Ͽ� �����ϰ� �������� Java ��ü�� ��ȯ�޾� ó�� ����
	//@Autowired ������̼ǰ� @Qualifier ������̼��� ����Ͽ� ������ ó��
	// => ������ ó���� �ʵ帶�� @Autowired ������̼� ��� 
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertStudent(Student student) {
		return sqlSession.getMapper(StudentMapper.class).insertStudent(student);
	}

	@Override
	public List<Student> selectStudentList() {
		return sqlSession.getMapper(StudentMapper.class).selectStudentList();
	}

}