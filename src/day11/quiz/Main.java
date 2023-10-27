package day11.quiz;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
        // List<Transaction>
        System.out.println("연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값)");
        transactions.stream()
                .filter(y -> y.getYear() == 2021)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("=================");
        System.out.println();
        // 연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.
        // List<String>
        // 거래목록에서 거래자들을 추출한담에 거래자안에 있는 도시이름을 추출
        // filter :  10개중에 조건에 맞는 3개를 필터링
        // map :  10개중에 10개를 가져오는데 조건에 맞게 추출
        System.out.println("연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.");
        transactions.stream()
                        .map(trader -> trader.getTrader().getCity())
                        .distinct()
                        .forEach(System.out::println);

        System.out.println();
        System.out.println("=================");
        System.out.println();
        // 연습 3: Cambridge에 근무하는 모든 거래자를 찾아 거래자리스트로 이름순으로 오름차정렬.
        // List<Trader>
        System.out.println("연습 3: Cambridge에 근무하는 모든 거래자를 찾아 거래자리스트로 이름순으로 오름차정렬.");
        transactions.stream()
                        .map(d->d.getTrader())
                        .filter(city -> city.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(t -> t.getName()))
                        .forEach(System.out::println);

        System.out.println();
        System.out.println("=================");
        System.out.println();
        // 연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로  오름차정렬하여 반환
        // List<String>
        System.out.println("연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로  오름차정렬하여 반환");
        List<String> collect = transactions.stream()
                .map(d -> d.getTrader().getName())
                .sorted() // 문자나 숫자는 Comparator를 사용하지 않음
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);

        System.out.println();
        System.out.println("=================");
        System.out.println();


        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
        System.out.println("연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?");
        boolean milan = transactions.stream()
                .anyMatch(d -> d.getTrader().getCity().equalsIgnoreCase("milan"));
        // equalsIgnoreCase --> 대,소문자를 불문하고 같은 문자인지 확인한다.
        System.out.println("Milan에 거래자가 있는가? = " + milan);

        System.out.println();
        System.out.println("=================");
        System.out.println();

        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.
        System.out.println("연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.");
        int cambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println("Cambridge 거래액 총합 = " + cambridge);

        System.out.println();
        System.out.println("=================");
        System.out.println();
        // 연습 7: 모든 거래에서 최고거래액은 얼마인가? -> 숫자 뽑기
        int max = transactions.stream()
                .mapToInt(trs -> trs.getValue())
                .max()
                .getAsInt();
        System.out.println("거래 최고액 = " + max);

        System.out.println();
        System.out.println("=================");
        System.out.println();

        // 연습 8. 가장 작은 거래액을 가진 거래정보 탐색 -> 객체 뽑기
        System.out.println("연습 8. 가장 작은 거래액을 가진 거래정보 탐색");
        Optional<Transaction> min = transactions.stream()
                .min(comparing(Transaction::getValue));

//        min.ifPresent(trs -> System.out.println(trs));
        Transaction transaction = min.get();
        System.out.println(transaction);

        System.out.println();
        System.out.println("=================");
        System.out.println();
    }
}
