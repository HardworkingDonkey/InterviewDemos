package com.donkey.interview.designpatterns;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.designpatterns
 * @description 适配器模式
 * @since 2020.10.26 18:46
 */

public class AdapterDemo {
    public static void main(String[] args) {
        // 将讲话者说的话放进聋哑人适配器, 聋哑人就可以知道他在讲什么
        System.out.println(new DeafMuteAdapter(new Speaker()).translate());
    }

    // 讲话者
    static class Speaker {
        public String speak() {
            return "speak...";
        }
    }

    // 手语翻译者
    interface SignLanguageTranslator {
        String translate();
    }

    // 聋哑人适配器
    static class DeafMuteAdapter implements SignLanguageTranslator {
        private Speaker speaker;

        public DeafMuteAdapter(Speaker speaker) {
            this.speaker = speaker;
        }

        @Override
        public String translate() {
            return speaker.speak();
        }
    }
}
