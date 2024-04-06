## ***Spring boot - PULSAR EXCAMEPLE*** ##

Introducing Spring for Apache Pulsar  
ref: https://www.youtube.com/watch?v=94Grr5IAIyk
Spring 공식 유튜브 펄사 소개  

영상에선 네이티브 클라우드의 메세징, 스트리밍앱 분산처리의 한종류로써  
kafka, rabbitmq, activemq등과 비슷한걸로 소개하고있습니다.  
Queue의 추상화작업 큐 의미론을 갖고있다.  

Pulsar: 
Message log  
multitenancy https://www.redhat.com/ko/topics/cloud-computing/what-is-multitenancy  
무국적 중개개념:  
  kafka  
   broker state storagㄷ save   
   1broker 1unit storage(10만개정도) 브로커와스토리지가 함께있어 무한이 증가 할수 없다  
  pulsar  
   state less broker 도 할수있다. / bokie, bookkeeper(무한히 확장)  

브로커 확장이 kafka보다 쉽다.   

향후 해볼 Exame  
https://github.com/majusko/pulsar-java-spring-boot-starter