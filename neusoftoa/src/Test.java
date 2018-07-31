import java.util.Date;
import java.util.List;

import com.neusoft.oa.hr.dao.IEmployeeDao;
import com.neusoft.oa.hr.factory.DaoFactory;
import com.neusoft.oa.hr.model.EmployeeModel;

public class Test {
	public static void main(String[] args) {
		IEmployeeDao edo = DaoFactory.createEmployeeDao();
		EmployeeModel em = new EmployeeModel();
		//插入数据测试
		em.setCode("01008");
		em.setName("pjcft");
		em.setAge(27);
		em.setSalary(4000.00);
		em.setBirthday(new Date());
		em.setDesc("测试");
		em.setSex("男");
		em.setPassword("123456");
		
		try {
			edo.create(em);
			System.out.println("ADD OK");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		/**删除测试
		em.setNo(6);
		
		try {
			edo.delete(em);
			System.out.println("Delete successfully!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		/**修改测试
		em.setNo(2);
		em.setCode("01001");
		em.setName("小彭");
		em.setAge(22);
		em.setSalary(3000);
		em.setBirthday(new Date());
		em.setDesc("A good boy!!");
		em.setSex("女");
		
		try {
			edo.update(em);
			System.out.println("Update successfully!!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		/**查询所有的测试
		try {
			List<EmployeeModel> list = edo.selectListByAll();
			//foreach循环输出
			for(EmployeeModel emm : list) {
				System.out.println(emm.getName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		/**有区间的分页查询
		try {
			EmployeeModel emm = edo.selectByNo(4);
			System.out.println(emm.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
//		//有年龄范围的分页查询
//		try {
//			List<EmployeeModel> list = edo.selectListByAgeScopeWithPage(21, 29, 2, 2);
//			for(EmployeeModel emm : list) {
//				System.out.println(emm.getNo());
//				System.out.println(emm.getCode());
//				System.out.println(emm.getName());
//				System.out.println(emm.getAge());
//				System.out.println(emm.getSalary());
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		//带年龄区间的无分页查询
//		try {
//			List<EmployeeModel> list = edo.selectListByAgeScope(23, 27);
//			for(EmployeeModel emm : list) {
//				System.out.println(emm.getNo());
//				System.out.println(emm.getCode());
//				System.out.println(emm.getName());
//				System.out.println(emm.getAge());
//				System.out.println(emm.getSalary());
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		//查询所有的有分页查询
//		try {
//			List<EmployeeModel> list = edo.selectListByAllWithPage(3, 2);
//			for(EmployeeModel emm : list) {
//				System.out.println(emm.getNo());
//				System.out.println(emm.getCode());
//				System.out.println(emm.getName());
//				System.out.println(emm.getAge());
//				System.out.println(emm.getSalary());
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		//统计所有的记录条数测试
//		try {
//			int emm = edo.selectCountByAll();
//			System.out.println(emm);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		//统计在年龄范围内的总条数测试
//		try {
//			int emm = edo.selectCountByAgeScope(20, 22);
//			System.out.println(emm);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}
}
