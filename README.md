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
   stateful, stateless 둘다 할수있다. / bokie, bookkeeper를 사용하여(무한히 확장)  

브로커 확장이 kafka보다 쉽다.   
이부분이 Pulsar의 포인트라고 한다.

Spring은 Pulsar가 Spring 친화적으로 제공되어야하기때문에 프로젝트를 만들었다고합니다.  

Pub-Sub 패턴에 속한다.
Pulsar Pattern = Pub-Sub
Message  
Topic   
Subscription  
Publisher  
Subscriber  

Kafka는 파티션으로 나누지만 Pulsar는 메세지 토픽등으로 분리한다.  
![img.png](src%2Fmain%2Fresources%2Freadmeimg%2Fimg.png)  


향후 해볼 Exame  
https://github.com/majusko/pulsar-java-spring-boot-starter