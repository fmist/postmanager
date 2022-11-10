package com.rustcohle.postmanager;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@SpringBootTest
class PostmanagerApplicationTests {

	@Test
	void add() {
		$(By.id("add")).click();
		$(By.id("title")).val("1и");
		$(By.id("add")).click();
		$(By.id("validate_title")).shouldHave(text("Заголовок должен содержать минимум 3 символа"));
		$(By.id("title")).val("q");
		$(By.id("add")).click();
		$(By.id("validate_text")).shouldHave(text("Описание не может быть пустым"));
		$(By.id("validate_title")).shouldNotBe(visible);
		$(By.id("text")).val("jf");
		$(By.id("add")).click();
		$(By.id("validate_text")).shouldHave(text("Описание не может быть пустым"));
		$(By.id("validate_title")).shouldNotBe(visible);
		$(By.id("text")).val("sw");
		$(By.id("add")).click();
	}

}
