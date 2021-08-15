
import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\u0010\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0017J \u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0017\u00a8\u0006\n"}, d2 = {"LDemoApplication;", "", "()V", "inputChannel", "Lorg/springframework/integration/channel/DirectChannel;", "integerMessageSource", "Lorg/springframework/integration/core/MessageSource;", "myFlow", "Lorg/springframework/integration/dsl/IntegrationFlow;", "messageSource", "Kotlin-Gradle-SpringBoot-Integration"})
@org.springframework.integration.config.EnableIntegration
@org.springframework.boot.autoconfigure.SpringBootApplication
public class DemoApplication {
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.context.annotation.Bean
    public org.springframework.integration.core.MessageSource<java.lang.Object> integerMessageSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.context.annotation.Bean
    public org.springframework.integration.channel.DirectChannel inputChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.context.annotation.Bean
    public org.springframework.integration.dsl.IntegrationFlow myFlow(@org.jetbrains.annotations.NotNull
    org.springframework.integration.core.MessageSource<java.lang.Object> messageSource, @org.jetbrains.annotations.NotNull
    org.springframework.integration.channel.DirectChannel inputChannel) {
        return null;
    }
    
    public DemoApplication() {
        super();
    }
}