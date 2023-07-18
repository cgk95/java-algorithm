package algorithm.STRING;


import java.util.Arrays;

public class ArraysNString {
    public static void main(String[] args) {
        ArraysNString sol = new ArraysNString();
        System.out.println(sol.isRotationOf("ababb", "bbabb"));
    }

    /**
     * s2가 s1을 회전시킨 결과인지 판별하는 메서드
     **/
    boolean isRotationOf(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        s1 = s1.repeat(2);
        return s1.contains(s2);
    }

    /**
     * 십자모양으로 0으로 채우는 메서드
     **/
    void setZeros(int[][] matrix) {
        boolean[] checkRow = new boolean[matrix.length];
        boolean[] checkCol = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    checkRow[i] = true;
                    checkCol[i] = true;
                }
            }
        }
        for (int i = 0; i < checkRow.length; i++) {
            zerifyRow(matrix, i);
        }
        for (int i = 0; i < checkCol.length; i++) {
            zerifyCol(matrix, i);
        }

    }

    private void zerifyCol(int[][] matrix, int i) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[i][j] = 0;
        }
    }

    private void zerifyRow(int[][] matrix, int i) {
        Arrays.fill(matrix[i], 0);
    }

    boolean rotate90(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length != matrix.length) {
            return false;
        }
        int N = matrix.length;
        for (int layer = 0; layer < N / 2; layer++) {
            int first = layer;
            int last = N - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // 윗 부분을 저장
                // 왼쪽 >> 위쪽
                matrix[first][i] = matrix[last - offset][first];
                // 아래쪽 >> 왼쪽
                matrix[last - offset][first] = matrix[last][last - offset];
                // 오른쪽 >> 아래쪽
                matrix[last][last - offset] = matrix[i][last];
                // 위쪽 >> 오른쪽
                matrix[i][last] = top;
            }
        }
        return true;
    }


    String compressBad(String target) {
        StringBuilder sb = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < target.length(); i++) {
            countConsecutive++;
            if (i + 1 >= target.length() || target.charAt(i + 1) != target.charAt(i)) { // 다음 문자가 범위를 벗어나거나 지금 문자와 다른 문자이면
                sb.append(target.charAt(i)).append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return sb.length() < target.length() ? sb.toString() : target; // 압축이 잘 되었을 때만 압축결과를 반환하고 반대의 경우 원래 문자열 반환
    }

    boolean oneEditAway(String str1, String str2) {
        //길이 체크 :: 하나 이상 차이나는지
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        // 길이가 어느쪽이 짧은지 확인하고
        String shorter = str1.length() < str2.length() ? str1 : str2;
        String longer = str1.length() < str2.length() ? str2 : str1;

        int index1 = 0;
        int index2 = 0;
        int foundDiff = 0;

        while (index2 < longer.length() && index1 < shorter.length()) {
            if (shorter.charAt(index1) != longer.charAt(index2)) {
                if (foundDiff > 0) { // 단 한번의 다름만 허용되므로
                    return false;
                }
                foundDiff++;
                if (str1.length() == str2.length()) { // 교체의 경우(서로 길이가 같은 두 문자열일 경우에 가능한 경우의 수는 교체 뿐이므로) 짧은 문자열의 포인터를 증가
                    index1++;
                }
            } else { // 짧은쪽의 포인터를 증가
                index1++;
            }
            index2++; // 긴 문자열의 포인터는 언제나 증가
        }
        return true; // 조건을 다 통과하면 true
    }

    /**
     * 팰린드롬의 순열인지 비트연산을 통해 확인하는 최적화된 방법
     **/
    boolean isPermutationOfPalindrome(String str) {
        int bitVector = createdBitVector(str);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector); // 비트가 모두 짝수로 세팅되었거나, 홀수개 세팅된 비트가 단 하나인지 확인하여 반환
    }

    /**
     * 정확히 비트 한 개만 1로 세팅되었는지 확인하기 위해 1을 뺀값과 AND 연산
     **/
    private boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    /**
     * 문자열에 대한 비트 벡터를 만든다. 값이 i인 문자의 경우 i번째 비트를 바꾼다.
     **/
    private int createdBitVector(String str) {
        int bitVector = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            int x = c - 'a';
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    /**
     * 정수의 idx 번째 비트값을 바꾸기
     **/
    private int toggle(int bitVector, int idx) {
        if (idx < 0) {
            return bitVector;
        }
        int mask = 1 << idx;
        if ((bitVector & mask) == 0) { // 해당하는 자리의 비트벡터가 0이라면 (이전까지 짝수횟수 등장 시)
            bitVector |= mask; // 비트를 1로 바꿔줌
        } else { // 해당 자리의 비트 벡터가 1이라면 ( 이전까지 홀수 횟수 등장 시 )
            bitVector ^= mask; // XOR 연산으로 0으로 바꿔주기
        }
        return bitVector;
    }

    boolean isUniqueChars(String str) {
        short checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) { // checker 변수의 val번째 비트가 이미 1로 설정되어 있는지 확인
                return false;
            }
            checker |= (1 << val); // 비트 OR 연산을 수행하여 checker 변수의 val번째 비트를 1로 설정
            System.out.println();
        }
        return true;
    }

    boolean isSubPermutationOfOther(String str1, String str2) {
        int size = str1.length() - str2.length();
        if (size != 0) {
            return false;
        }
        return sortString(str1).equals(sortString(str2));
    }

    public String sortString(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

}
