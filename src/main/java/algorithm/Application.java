package algorithm;
import algorithm.domain.*;
public class Application {
    /**
     * domain 내의 알고리즘 문제 클래스를 생성하여 실행
     **/
    public static void main(String[] args)  throws Exception{
        try{
            BOJ_2116 sol=new BOJ_2116();
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
