package pl.kaczanowscy.tomek;

import org.springframework.web.servlet.ModelAndView;

import static pl.kaczanowscy.tomek.ModelAndViewAssert.assertThat;


public class Example {

    public static void main(String[] args) {
        ModelAndView noNameMav = new ModelAndView();

        assertThat(noNameMav).hasNoName();

        ModelAndView mavWithName = new ModelAndView("mav_name");

        assertThat(mavWithName).hasName("mav_name");

        ModelAndView mav = new ModelAndView();
        mav.addObject("string", "some_value");
        Object obj = new Object();
        mav.addObject("obj", obj);
        mav.addObject("int", 5);
        mav.addObject("Long", 5L);


        assertThat(mav).contains("string").contains("obj").contains("int").contains("Long");
        assertThat(mav).contains("string", "some_value").contains("obj", obj).contains("int", 5).contains("Long", 5L);

        assertThat(mav).doesNotContain("other_string");

        // some syntactic sugar if you like it

        assertThat(mav).contains("string").and().contains("int").but().doesNotContain("other_string");

    }
}
