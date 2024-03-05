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

LazyConnection 사용하려면 bean으로 사용하는게 편해서
콘피그로 등록하려는데...
![jooqconf.png](img%2Fjooqconf.png)
이렇게설정하면 QueryDsl처럼 Q파일이 생성되야할거같은데  
묵묵부답이다.. 뭐가잘못된건지 찾아봐야거할같다.

