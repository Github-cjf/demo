package org.sang.demo.test;

import org.springframework.stereotype.Component;

/**
 * Created by CJF on 2019/3/13.
 */
@Component
public class TestAutowired {
    public interface Ranks {

    }

    @Component
    public class RankOne implements Ranks {
        private String rank1 = "Rank1";

        public String toString() {
            return this.rank1;
        }
    }

    @Component
    public class RankTwo implements Ranks {
        private String rank2 = "Rank2";

        public String toString() {
            return this.rank2;
        }
    }

    @Component
    public class RankThree implements Ranks {
        private String rank3 = "Rank3";

        public String toString() {
            return this.rank3;
        }
    }

//    @Component
//    public class Results {
//        @Autowired
//        private List<Ranks> ranks;
//    }

}
