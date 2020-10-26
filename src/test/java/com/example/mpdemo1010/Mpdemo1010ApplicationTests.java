package com.example.mpdemo1010;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mpdemo1010.entity.User;
import com.example.mpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class Mpdemo1010ApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);


	}
	@Test
	public void addUser(){
        User user=new User();
        user.setAge(60);
        user.setName("yue");
        user.setEmail("lucy1@qq.com");
		int insert = userMapper.insert(user);
	}

	@Test
	public void updateUser(){
		User user=new User();
		user.setId(2L);
		user.setAge(25);
		user.setEmail("lucy2@qq.com1");
		int insert = userMapper.updateById(user);
	}
	@Test
	public void delUser(){

		int insert = userMapper.deleteById(1320630031710695426l);
		System.out.println("insert====="+insert);
	}

	@Test
	public void testOptimisticLocker(){
		User user=userMapper.selectById(1320612291604226049l);
		user.setName("DongFang2");
		user.setEmail("lucy2@qq.com1");
		int insert = userMapper.updateById(user);
	}
	@Test
	public void testSelectDemo1(){
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
  		users.forEach(System.out::println);

	}
	@Test
	public void testPage(){
		Page<User> page=new Page<>(1,3);
		userMapper.selectPage(page,null);
		System.out.println("========分页数据============");
		System.out.println(page.getCurrent());//当前页
		System.out.println(page.getRecords());//每页数据list集合
		System.out.println(page.getSize());//每页显示记录数
		System.out.println(page.getTotal());//总记录数
		System.out.println(page.getPages());//总页数
		System.out.println(page.hasNext());//下一页
		System.out.println(page.hasPrevious());//上一页
	}

}
