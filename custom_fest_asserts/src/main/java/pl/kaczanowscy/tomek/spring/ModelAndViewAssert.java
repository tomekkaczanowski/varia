package pl.kaczanowscy.tomek;

import org.fest.assertions.*;
import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewAssert extends GenericAssert<ModelAndViewAssert, ModelAndView> {

    public ModelAndViewAssert(ModelAndView actual) {
        super(ModelAndViewAssert.class, actual);
    }

    public static ModelAndViewAssert assertThat(ModelAndView actual) {
        return new ModelAndViewAssert(actual);
    }

    public ModelAndViewAssert hasNoName() {
        isNotNull();
        String errorMessage = String.format("Expected model's name to be null but was <%s>", actual.getViewName());
        Assertions.assertThat(actual.getViewName()).overridingErrorMessage(errorMessage).isNull();
        return this;
    }

    public ModelAndViewAssert hasName(String name) {
        isNotNull();
        String errorMessage = String.format("Expected model's name to be <%s> but was <%s>",name, actual.getViewName());
        Assertions.assertThat(actual.getViewName()).overridingErrorMessage(errorMessage).isEqualTo(name);
        return this;
    }

    public ModelAndViewAssert contains(String name, Object obj) {
        isNotNull();
        Object found = actual.getModelMap().get(name);
        String errorMessage = String.format("Expected model to contain <%s> under name <%s> but <%s> was found instead", obj, name, found);
        Assertions.assertThat(found).overridingErrorMessage(errorMessage).isEqualTo(obj);
        return this;
    }

    public ModelAndViewAssert contains(String name) {
        isNotNull();
        String errorMessage = String.format("Expected model to contain object under name <%s> but it was not found", name);
        Assertions.assertThat(actual.getModelMap().get(name)).overridingErrorMessage(errorMessage).isNotNull();
        return this;
    }

    public ModelAndViewAssert doesNotContain(String name) {
        isNotNull();
        String errorMessage = String.format("Expected model NOT to contain object under name <%s> but it was found", name);
        Assertions.assertThat(actual.getModelMap().get(name)).overridingErrorMessage(errorMessage).isNull();
        return this;
    }

    // syntactic sugar :)
    public ModelAndViewAssert but() {
        return this;
    }

    public ModelAndViewAssert and() {
        return this;
    }
}