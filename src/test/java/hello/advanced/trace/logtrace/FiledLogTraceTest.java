package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class FiledLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    public void begin_end_level2() throws Exception {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        TraceStatus status3 = trace.begin("hello3");
        trace.end(status1);
        trace.end(status2);
        trace.end(status3);

    }

    @Test
    public void begin_exception_level2() throws Exception {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status1, new IllegalStateException());
        trace.exception(status2, new IllegalStateException());

    }
}
