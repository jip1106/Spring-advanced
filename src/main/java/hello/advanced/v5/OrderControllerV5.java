package hello.advanced.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }


    @GetMapping("/v5/request")
    public String request(@RequestParam(name="itemId" , defaultValue="ex" , required=false) String itemId){
        return template.execute("OrderController.request()", new
            TraceCallback<>() {
                @Override
                public String call() {
                    orderService.orderItem(itemId);
                    return "ok";
                }
            });
    }

    @GetMapping("/v5/requestLamda")
    public String requestLamda(@RequestParam(name="itemId" , defaultValue="ex" , required=false) String itemId){
        return template.execute("OrderController.request()", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });
    }

}
