//package com.example.demo;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.demo.models.comments;
//import com.example.demo.models.questions;
//import com.example.demo.models.subreddit;
//import com.example.demo.models.user;
//
//
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4000")
//public class Restcontroller {
//	
//	
//	RestTemplate rest=new RestTemplate();
//	HttpHeaders headers = new HttpHeaders();
//
//
//	@Autowired
//	private question_interface questioni;
//	
//	@Autowired
//	private subreddit_interface subredditi ;
//	
//	@Autowired
//	private user_interface useri;
//	
//	
//	
//    //Hell Hell=new Hell(5);
//	@GetMapping("/findquestionbyid/{question_id}")
//	public Optional<questions> findquestion(@PathVariable int question_id) 
//    {
//		questions temp=new questions();
//		temp.setId(question_id);
//		Example<questions> user_examp=Example.of(temp);
//		return questioni.findById(question_id);
//        //console.log('executed service')
//		
//    }
//	
//	@GetMapping("/findsubredditbyid/{subreddit_id}")
//	public Optional<subreddit> findsubreddit(@PathVariable int subreddit_id ) 
//    {
//        //console.log('executed service')
//		System.out.println(subreddit_id );
//		subreddit temp=new subreddit();
//		temp.setId(subreddit_id );
//		Example<subreddit> user_examp=Example.of(temp);
//		return subredditi.findById(subreddit_id);
//    }
//	
//	@GetMapping("/finduserbyusername/{user_id}")
//	public Optional<user> finduser(@PathVariable String user_id) 
//    {
//        //console.log('executed service')
//		
//		System.out.println(user_id);
//		user temp=new user();
//		temp.setUsername(user_id);
//		Example<user> user_examp=Example.of(temp);
//		return useri.findOne(user_examp);
//	
//    }
//	
//	
//	
//	@PostMapping("/add/user")
//	public String add_user(@RequestBody user User)
//	{
//	
//		useri.save(User);
//		return "added user";
//	}
//	@PostMapping("/update/user")
//	public String update_user(@RequestBody user User)
//	{
//		useri.deleteById(User.getUsername());
//		useri.save(User);
//		return "added user";
//	}
//	@PostMapping("/update/subreddit")
//	public String update_subreddit(@RequestBody subreddit Subreddit)
//	{
//		subredditi.deleteById(Subreddit.getId());
//		subredditi.save(Subreddit);
//		return "added_subreddit";
//	}
//	@PostMapping("/update/question")
//	public String update_question(@RequestBody questions Questions)
//	{
//		questioni.deleteById(Questions.getId());
//		questioni.save(Questions);
//		return "added_questions";
//	}
//
//	
//	@PostMapping("add/question")
//	public String add_question(@RequestBody questions Questions)
//	{
//		questioni.save(Questions);
//		return "added_questions";
//	}
//	
//	@PostMapping("add/subreddit")
//	public String add_subreddit(@RequestBody subreddit Subreddit)
//	{
//		
//		subredditi.save(Subreddit);
//		return "added_subreddit";
//	}
//
//}


package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.comments;
import com.example.demo.models.questions;
import com.example.demo.models.subreddit;
import com.example.demo.models.user;



@RestController
@CrossOrigin(origins = "http://localhost:4000")
public class Restcontroller {
	
	
	RestTemplate rest=new RestTemplate();
	HttpHeaders headers = new HttpHeaders();


	@Autowired
	private question_interface questioni;
	
	@Autowired
	private subreddit_interface subredditi ;
	
	@Autowired
	private user_interface useri;
	
	
	
    //Hell Hell=new Hell(5);
	@GetMapping("/findquestionbyid/{question_id}")
	public Optional<questions> findquestion(@PathVariable int question_id) 
    {
		questions temp=new questions();
		temp.setId(question_id);
		Example<questions> user_examp=Example.of(temp);
		return questioni.findById(question_id);		
    }
	
	@GetMapping("/findsubredditbyid/{subreddit_id}")
	public Optional<subreddit> findsubreddit(@PathVariable int subreddit_id ) 
    {
		subreddit temp=new subreddit();
		temp.setId(subreddit_id );
		Example<subreddit> user_examp=Example.of(temp);
		return subredditi.findById(subreddit_id);
    }
	
	@GetMapping("/finduserbyusername/{user_id}")
	public Optional<user> finduser(@PathVariable String user_id) 
    {
        //console.log('executed service')
		
		System.out.println(user_id);
		user temp=new user();
		temp.setUsername(user_id);
		Example<user> user_examp=Example.of(temp);
		return useri.findOne(user_examp);
	
    }
	
	@GetMapping("/allsubreddit")
	public List<subreddit> allsubreddit() 
    {
        //console.log('executed service')
		
		
		return subredditi.findAll();
		
	
    }
	
	
	@PostMapping("/add/user")
	public int add_user(@RequestBody user User)
	{
		if(useri.findById(User.getUsername()).isEmpty())
		{
			useri.save(User);
			return 1;
		}
		else {
			
			return 0;
		}
	}
	@PostMapping("/update/user")
	public String update_user(@RequestBody user User)
	{
		useri.deleteById(User.getUsername());
		useri.save(User);
		return "added user";
	}
	@PostMapping("/update/subreddit")
	public String update_subreddit(@RequestBody subreddit Subreddit)
	{
		subredditi.deleteById(Subreddit.getId());
		subredditi.save(Subreddit);
		return "added_subreddit";
	}
	@PostMapping("/update/question")
	public String update_question(@RequestBody questions Questions)
	{
		questioni.deleteById(Questions.getId());
		questioni.save(Questions);
		return "added_questions";
	}

	
	@PostMapping("add/question")
	public String add_question(@RequestBody questions Questions)
	{
		questioni.save(Questions);
		return "added_questions";
	}
	
	@PostMapping("add/subreddit")
	public String add_subreddit(@RequestBody subreddit Subreddit)
	{
		
		subredditi.save(Subreddit);
		return "added_subreddit";
	}

}