package com.example.demo.controller.helloworld;

import com.example.demo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 当我们在控制器层返回 ResponseEntity 对象时，Spring MVC 框架会使用 HttpEntityMethodProcessor 类来处理它。HttpEntityMethodProcessor 是 AbstractMessageConverterMethodProcessor 的一个子类，它专门处理返回值类型是 HttpEntity 或 ResponseEntity 的控制器方法。
 *
 * HttpEntityMethodProcessor 的处理过程如下：
 *
 * 首先，检查返回值是否为空，如果为空，就直接返回。
 * 然后，创建 ServletServerHttpRequest 和 ServletServerHttpResponse 对象，用于读取请求和写入响应。
 * 接着，断言返回值是 HttpEntity 类型的，并将其强制转换为 HttpEntity 或 ResponseEntity 对象。
 * 然后，获取输出消息的标头和实体标头，并将实体标头复制到输出标头中。
 * 接着，判断返回值是否是 ResponseEntity 类型的，并获取其状态码，并设置到输出消息中。
 * 最后，调用父类的 writeWithMessageConverters 方法，根据实体类型和请求内容协商选择合适的消息转换器，并将实体内容写入到输出消息中。
 */
@RestController
@RequestMapping("/helloworldx")
public class helloworldx {


    /**
     * 请求地址：http://localhost:8518/api/helloworldx/hello
     * @return
     */
    @GetMapping ("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity <> ("Hello World!", HttpStatus.OK);
    }
    @GetMapping ("/hello2")
    ResponseEntity<String> hello2() {
        return ResponseEntity.ok ("Hello World!");
    }
    @GetMapping ("/age")
    ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {
        if (yearOfBirth > 10) {
            return new ResponseEntity <> ("年份不正确", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity <> ("你的年龄是" + yearOfBirth, HttpStatus.OK);
    }

    @GetMapping ("/customHeader")
    ResponseEntity<String> customHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add ("Custom-Header", "foo");
        return new ResponseEntity <> ("自定义头部", headers, HttpStatus.OK);
    }
    /**
     * 请求地址：http://localhost:8518/api/helloworldx/test1/1
     * @return
     */
    @GetMapping("/test1/{id}")
    public HttpEntity test1(@PathVariable Long id) {
        if (id == 1) {
            return new ResponseEntity(new User(123456,"KIBA"), HttpStatus.OK);
        } else{
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/test2")
    public HttpEntity test2(@RequestBody User user) {
        if (user == null) {
            return new ResponseEntity(new User(123456,"KIBA"), HttpStatus.OK);
        } else{
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }


}
