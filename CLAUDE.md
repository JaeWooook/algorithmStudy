# JavaAlgorithmStudy

백준(BOJ) 알고리즘 공부용 저장소. 사용자가 직접 풀이하는 것이 목적이므로, **문제 생성 시 풀이는 쓰지 않고** 입력 파싱까지만 작성한다. (풀이를 요청받았을 때만 작성)

## 프로젝트 구조

- 소스 루트: 프로젝트 루트 (`.idea/AlgorithmStudy.iml`), JDK 17
- 문제 경로: `Java/BOJ/<주제>/BOJ_<순번>_<문제번호>.java`
- 패키지: `Java.BOJ.<주제>` (예: `Java.BOJ.Hash`) — 폴더 경로와 반드시 일치
- 주제 폴더 예: `BFS`, `BackTracking`, `BinarySearch`, `Dequeue`, `Exhaustive_Search`, `Greedy`, `Hash`, `Queue`, `Sort`, `Stack`, `String`
- 주제 폴더에 `<주제>Template.java`(예: `HashTemplate.java`)가 있으면 그것을 복사해서 시작한다. 없으면 `Java/BOJ/Hash/HashTemplate.java`를 기준으로 만든다.
- 인코딩 UTF-8 (`.idea/encodings.xml`). 한글 주석 사용, CLI 컴파일 시 `javac -encoding UTF-8`

## 문제 생성 절차

1. **주제/난이도/개수 확인**: 사용자가 말한 주제 폴더와 난이도 분포(하 / 중 / 중상)를 따른다. 별도 요청이 없으면 하 2, 중 3, 중상 5 정도로 중상 비중을 높인다.
2. **중복 방지**: 해당 폴더의 기존 파일을 `ls`로 확인하고, 이미 있는 문제번호는 제외한다. 다른 폴더(예: BinarySearch의 10816)에 있는 문제도 가급적 피한다.
3. **문제 선정**: 아래 "문제 선정 기준"에 따라 고르고 난이도순(쉬운 것 → 어려운 것)으로 정렬한다.
4. **번호 부여**: `<순번>`은 폴더 내 마지막 번호 + 1부터 연속으로 붙인다. 난이도순으로 정렬되도록 번호를 배정한다.
5. **파일 생성**: 아래 파일 형식을 따라 문제당 클래스 1개를 만든다.
6. **컴파일 확인**: `javac -encoding UTF-8 -d "$TEMP/jout" Java/BOJ/<주제>/*.java` 로 전부 컴파일되는지 확인한다. (`out/` 폴더에 산출물을 만들지 않는다.)
7. **커밋은 사용자가 요청할 때만** 한다. 커밋 메시지 관례: `BOJ YYMMDD <주제> <수준> 문제 풀이` (예: `BOJ 260128 BinarySearch 기본문제 풀이`)

## 문제 선정 기준

"질 좋고 주제 학습에 적합한 문제"는 아래 기준을 **위에서부터 우선순위대로** 적용해 고른다.

### 1. 출처 우선순위
1. **바킹독 실전 알고리즘 문제집** (BOJ 문제집, 주제별 "연습 문제/기본 문제" 목록) — 기존 폴더(BFS: 1926, 2178, 7576…, Hash: 7785, 1620, 13414…)가 이 목록을 따르고 있으므로 1순위. 폴더에 이미 있는 문제 다음 순서부터 가져온다.
2. **solved.ac 클래스 문제** (CLASS 2~5) 중 해당 태그 문제 — 검증된 필수 유형.
3. **solved.ac 태그 검색** — 위 두 곳에서 부족할 때 아래 조건으로 검색해 보충한다.

### 2. 정량 기준 (solved.ac 검색)
- 검색 주소: `https://solved.ac/search?query=<쿼리>&sort=solved&direction=desc` (맞힌 사람 많은 순)
- 쿼리 예: `#hash_set *s4..g3 s#1000.. lang:ko -@<BOJ아이디>`
  - `#태그` : 주제 태그 (아래 태그 표 참고)
  - `*s4..g3` : 난이도 범위
  - `s#1000..` : 맞힌 사람 1000명 이상 (검증된 문제, 반례/풀이 자료가 충분함)
  - `lang:ko` : 한국어 문제
  - `-@아이디` : 이미 푼 문제 제외 (사용자가 아이디를 알려준 경우)
- 정답 비율이 극단적으로 낮은(약 20% 미만) 문제는 입출력 함정 위주일 수 있으므로 "중상" 이상에서만 1개 이하로 포함.

### 3. 난이도 매핑 (solved.ac 티어)
| 구분 | 티어 | 의미 |
|---|---|---|
| 하 | 실버5 ~ 실버4 | 자료구조 사용법 자체를 익히는 문제 |
| 중 | 실버3 ~ 실버2 | 자료구조 + 간단한 아이디어 (카운팅, 조합 등) |
| 중상 | 실버1 ~ 골드3 | 다른 기법과 결합 (슬라이딩 윈도우, 이분탐색, 부분합, 투포인터 등) |

### 4. 정성 기준 (주제 적합성)
- **주제가 풀이의 핵심**이어야 한다. 태그에 주제가 있어도 실제로는 다른 알고리즘이 핵심이면 제외. (예: Hash 폴더에 사실상 순수 우선순위 큐 문제는 넣지 않음)
- **유형이 겹치지 않게** 섞는다. 예) Hash: 존재 확인(Set) / 카운팅(Map) / 조합 계산 / 부분 문자열 / 슬라이딩 윈도우 결합 / 부분합 결합
- **같은 문제의 변형만 반복하지 않는다.** (숫자 카드 → 숫자 카드 2 같은 쌍은 하나만)
- 다른 폴더에 이미 있는 문제는 제외 (`grep -rl "boj <번호>" Java/BOJ` 로 확인).
- 특수 채점(스페셜 저지), 서브태스크 위주, 언어 제한 문제는 제외.

### 5. 주제별 solved.ac 태그
| 폴더 | 태그 |
|---|---|
| Hash | `#hash_set`, `#set` |
| BinarySearch | `#binary_search` |
| BFS | `#bfs` |
| BackTracking | `#backtracking` |
| Stack / Queue / Dequeue | `#stack` / `#queue` / `#deque` |
| Sort | `#sorting` |
| Greedy | `#greedy` |
| String | `#string` |
| Exhaustive_Search | `#bruteforcing` |

### 6. 검증
- 문제 번호/제목/입출력 형식은 Claude의 기억에 의존하므로 틀릴 수 있다. 가능하면 WebFetch로 `https://www.acmicpc.net/problem/<번호>` 또는 solved.ac 페이지를 확인하고, 확인하지 못했다면 **"사이트에서 확인 필요"라고 사용자에게 명시**한다.
- 생성 후 문제 목록을 표(클래스 / 문제 / 티어 / 포인트 / URL)로 보여준다.

## 파일 형식

```java
package Java.BOJ.Hash;
import java.io.*;
import java.util.*;

public class BOJ_8_14425 {

    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //Hash 기본문제 boj 14425 (하 / 실버4)
            //https://www.acmicpc.net/problem/14425
            //https://testcase.ac/problems/boj/14425
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            /**
             * [문제 제목] 문제 요약 한두 줄
             * 입력: 입력 형식 요약 (범위 포함)
             * 출력: 출력 형식 요약
             * 포인트: 사용할 자료구조/알고리즘, 주의점 (long 오버플로, 시간복잡도 등)
             */
            // 입력 파싱 (공통 메서드 사용)
            int[] nm = readInts();
            ...

            // TODO 풀이

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        // ===== 공통 입력 메서드 (복붙용) =====
        // readInt / readLine / readInts / readIntArray / readStringArray / readString2DArray
    }
}
```

규칙:
- 외부 클래스 `BOJ_<순번>_<문제번호>` 안에 `public static class Main`을 둔다 (BOJ 제출 시 안쪽 `Main`만 복사해 쓰기 위함).
- `main` 첫 부분에 `//<주제> 기본문제 boj <문제번호> (<난이도 / 티어>)` 주석 다음 줄에 `//https://www.acmicpc.net/problem/<문제번호>` 를 넣는다.
- 이어서 반례/테스트케이스 확인용 `//https://testcase.ac/problems/boj/<문제번호>` 줄도 넣는다.
- 공통 입력 메서드(`readInt`, `readLine`, `readInts`, `readIntArray`, `readStringArray`, `readString2DArray`)는 `HashTemplate.java` 하단 블록을 **그대로** 복사한다. 필요한 경우에만 메서드를 추가한다.
- 입력 파싱 코드는 문제 입력 형식에 맞게 작성하되, 풀이 로직은 `// TODO 풀이` 로 비워 둔다.
- 테스트케이스 여러 개인 문제는 `while (t-- > 0)` 루프 안에 파싱과 `// TODO 풀이`를 둔다.
- 답이 int 범위를 넘을 수 있는 문제는 주석 포인트에 `long 주의`를 적는다.

## 새 주제 폴더를 만들 때

1. `Java/BOJ/<주제>/` 폴더 생성
2. `<주제>Template.java` 생성 (`HashTemplate.java`를 복사하고 패키지/클래스명/주석 수정)
3. 이후 위의 문제 생성 절차를 따른다.

## 사용자 요청 예시

- "BOJ <주제> 문제 10개 만들어줘. 하 2개, 나머지는 중~중상" → 위 절차대로 생성
- "<문제번호> 풀이해줘" → 해당 파일의 `// TODO 풀이` 부분에 풀이 작성 후 컴파일 확인, 접근 방식을 주석(`/** ... */`)으로 남긴다.
