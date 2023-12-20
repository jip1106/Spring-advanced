package hello.advanced.trace.strategy.code.strategy;

import hello.advanced.trace.strategy.code.template.Callback;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     * @throws Exception
     */
    @Test
    public void callbackV1() throws Exception {
        TimeLogTemplate template = new TimeLogTemplate();
        template.excute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        template.excute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 템플릿 콜백 패턴 - 람다
     * @throws Exception
     */
    @Test
    public void callbackV2() throws Exception {
        TimeLogTemplate template = new TimeLogTemplate();
        template.excute(() -> log.info("비즈니스 로직1 실행"));
        template.excute(() -> log.info("비즈니스 로직2 실행"));
    }
}
