package com.monkey01.springbootstart;

import com.demo.SpringbootStartApplication;
import com.demo.common.util.DateUtil;
import com.demo.entity.Count;
import com.demo.entity.User;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootStartApplication.class)
public class SpringbootStartApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {
//		//向缓存中保存一组数据：key=admin value=123456
		stringRedisTemplate.opsForValue().set("admin","123456");

//		//从缓存中取出key=admin对应的value值
		String str = stringRedisTemplate.opsForValue().get("admin");
		System.out.println(str);

		//查看全部key
		List<String> keys = new ArrayList<>(Objects.requireNonNull(stringRedisTemplate.keys("*")));
		System.out.println(keys.size());
		//循环输出结果
		for (String key : keys) {
			System.out.println(key);
		}
	}

	@Test
	public void test01() {
		User user = new User();
		user.setUsername("111");
		System.out.println(user);


	}

	public static void main(String[] args) {

//		System.out.println(4&7);

//		System.out.println(Count.class);
//		System.out.println(DateUtil.DATE_MONTH_HOUR_PATTERN);

		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");

		//1.for循环遍历
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}

		//2.for each 新循环遍历
		for(String str : list) {
			System.out.println(str);
		}

		//3.迭代器遍历
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}



		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);

		/**
		 *
         * 遍历所有的key
         * Set<k> keySet()
         * 该方法会将当前Map中所有的key存入一个
         * Set集合后返回。那么遍历该集合就等于遍历
         * 了所有的key
         */
		Set<String> keySet = map.keySet();
		for(String key:keySet) {
			System.out.println("key" + key);
		}

		/*
         * 遍历每一组键值对
         * Map中每一组键值对都是由Map的内部类：
         * java.util.Map.Entry的一个实列表示的。
         * Entry有两个方法：getKey，getValue，可以
         * 分别获取这一组键值对中的key与value。
         * 
         * Set<Entry>entrySet
         * 该方法会将Map中每一组键值对(Entry实例)
         * 存入一个Set集合后返回。
         */
		Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
		for(Map.Entry<String,Integer> e:entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
		}

		/*
         * 遍历所有的value
         * Collection values()
         * 该方法会将当前Map中所有的value存入一个
         * 集合后返回。
         */
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println(value);
		}




	}

	String a = "abc";
	String b = new String("abc");
	//问：a和b地址相同吗


}

