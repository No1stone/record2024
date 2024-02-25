
### **jpa를 사용하면서 격었던 것중 기억에 남는 쿼리 재현**  
올바른 처리방법은 아니었지만. 이렇게도 처리가 되더라...  

1. unionAll 처리  
    case: jpa, queryDSL 로만 처리해야하는 쿼리에서 unionALL,  
        서브쿼리에 where 절을 사용해야함.
    제약사항:   
        1. 고객사의 허락없이는 서트파티 추가 불가 Query 처리.    
        2. PM이 쿼리로 처리 하라고 지시한 사항.
    문제: 회사정보, 유저정보, 단체 등 각각의 Table로 존재하는상황 (ex. linkedin profile)
    해결: View Table을 UnionALL로 생성 후 JPA Entity로 해당 테이블 조회   
    부작용:    
        1. 테이블 수정이 있을 경우 view테이블과 의존관계가 발생하여 유지보수가 불편함.   
        2. 뷰테이블을 조회시 테이블생성쿼리가 동작하여 성능이좋지않은 unionQuery 조회/인덱스도 불가.    

2.  N번이상 조인이 들어간 endpoint Table의 상태 동적업데이트  
    case: 1트랜젝션 이내에 처리해야하는 쿼리로 Bulk Modify를 처리해야함   
         ( 전화 캠페인으로서 대기열 테이블의 상태를 변경 및 키워드로 분기 액션을 취하는상황 )  
    제약사항: BulkUpdate 1 Transaction    
    문제:   
         1. InQuery를 사용하기에 데이터양을 알수없음       
         2. 시도회수, API성공Status, 서버에서 반환받은Status, 현재상태Status등 다중케이스 업데이트      
         3. BulkUpdate, BulkInsser, BulkDelete 가 이루어짐  
    헤결: entityManager NativeQuery 사용   
    부작용: 네이티브 쿼리사용으로 IDE레벨에서 즉각 디버깅이 힘듬.   
