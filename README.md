**jooq?**
============
https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.7-Release-Notes  
Spring 2.7 Releas Note에 jooq이란게 있길래 찾아보았다. 
QueryDSL 과 같은 Entity 기반의 쿼리 툴이라고한다.  
https://www.jooq.org/download/  
2024/03/05 지원되는 Database  
![jooqusedb.png](img%2Fjooqusedb.png)
jooq 공식문서
https://www.jooq.org/doc/3.19/manual/
Spring jooq 공식문서  
https://docs.spring.io/spring-boot/docs/1.3.5.RELEASE/reference/html/boot-features-jooq.html

![springdocjooq.png](img%2Fspringdocjooq.png)
Java 기반의 쿼리를작성하고 싶으면 Codejen을 추가하라고한다.  

Jooq Javadoc
https://www.jooq.org/javadoc/latest/org.jooq/module-summary.html

Jooq Java Bean
https://www.jooq.org/doc/latest/manual/code-generation/codegen-configuration/

사람들 예제를보니 gradle, Maven으로 바로 의존성을 넣는데  
LazyConnection 사용할땐 어떻게 하는거지 라는 의문이 든다..  
GenerationTool 로 codejen 을 생성해주는데  
Datasource를 받으니...  
LazyConnection 사용하려면 bean콘피그로 등록되는지 봐야하니...  
![jooqdir.png](img%2Fjooqdir.png)
얼추 성공...  
구글링 해도 이렇게 설정 잡는사람 없는걸보니  
이런뻘짓은 나만 했나보다...  

  
QueryDsl은 Spring6, boot3으로오면서 Q file dir을 크게신경안써도 되게된거같던데  
dir에 가봐도 Q파일은 안보인다. 
![qfile.png](img%2Fqfile.png)

