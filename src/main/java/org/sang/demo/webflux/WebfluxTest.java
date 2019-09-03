package org.sang.demo.webflux;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by CJF on 2019/5/9.
 */
public class WebfluxTest {
    Mono<ServerResponse> test(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("12"));
    }

    public static void main(String[] args) {
//        Collector<Integer, List<List<Integer>>, List<List<Integer>>> c = Collector.of(ArrayList::new, (l, i) -> {
//            if (l.isEmpty()) {
//                List<Integer> li = new ArrayList<>();
//                li.add(i);
//                l.add(li);
//            } else {
//                List<Integer> last = l.get(l.size() - 1);
//                if (last.size() < 2) {
//                    last.add(i);
//                } else {
//                    List<Integer> li = new ArrayList<>();
//                    li.add(i);
//                    l.add(li);
//                }
//            }
//        }, (l1, l2) -> {
//            l1.addAll(l2);
//            return l1;
//        });

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

//        List<List<Integer>> result = l.stream().collect(c);
//        System.out.println(result);
        Iterator<Integer> iterable = l.iterator();
        while (iterable.hasNext()) {
//            Integer i = iterable.next();
            if(iterable.next() == 3) {
                iterable.remove();
            } else {
//                System.out.println(i);
            }
        }
        System.out.println(l);
    }
}
