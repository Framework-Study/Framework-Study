package com.sparta.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/request")
public class HelloRewquestcontroller {

    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    //URL 경로로 들어온 값을 파라미터로 사용
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name,
                                   @PathVariable int age)
    {
        return String.format("Hello, @Path Variable. <br>name = %s, age = %d", name, age);
    }

    // 1개의 http요청 파라미터를 받음. 파라미터 여부(requred) 옵션이 default로 true기 때문에 반드시 전송되어야 한다.
    @PostMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name,
                                       @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // Json->Java객체. Spring Controller에서 값을 받을 때 default설정. 생성자나 setter가 필요함
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }

    // Json->Java객체 선택적으로 Valid 어노테이션으로 자동유효성 검사도 가능. setter나 생성자 필요x
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }
}
