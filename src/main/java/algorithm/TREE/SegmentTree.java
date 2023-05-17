package algorithm.TREE;

/**
 * 숫자가 저장된 배열이 존재할 때 해당 배열의 구간 합을 구하거나,
 * 배열의 특정 인덱스의 값을 변경한 후에 다시 구간합을 구해야 한다면 세그먼트 트리를 사용
 */
public class SegmentTree {
    // 세그먼트 트리를 구현할 배열
    private long[] tree;

    public SegmentTree(int n) {
        // 트리 높이 :: 세그먼트 트리의 높이 = logN(밑이 2인 로그)의 값을 올림 한 후 + 1
        double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
        // 트리의 노드 수 :: 세그먼트 트리의 전체 노드 수 = 2^(트리의 높이)
        long treeNodeCount = Math.round(Math.pow(2, treeHeight));
        // 트리 길이
        tree = new long[Math.toIntExact(treeNodeCount)];
    }

    public long init(long[] arr, int node, int start, int end) {
        // 세그먼트 트리의 노드인 경우
        if (start == end) {
            return tree[node] = arr[start];
        } else {
            // 리프노드가 아닌 경우에는 두 자식노드의 값을 더해서 노드의 값을 초기화한 후 리턴
            // 자식 노드 번호 (좌측) = 부모 노드 번호 * 2
            // 자식 노드 번호 (우측) = (부모 노드 번호 * 2) +1
            return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                    + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
        }
    }

    /**
     * 느리게 갱신되는 세그먼트 트리
     * 느리게 갱신되는 세그먼트 트리를 사용하면 구간 변경을 효율적으로 수행할 수 있음
     */
    void update_range(long[] tree, int node, int start, int end, int left, int right, long diff) {
        // 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)가 포함되지 않을 경우
        if (left > end || right < start) {
            return;
        }
        if (start == end) {
            tree[node] += diff;
            return;
        }
        update_range(tree, node * 2, start, (start + end) / 2, left, right, diff);
        update_range(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right, diff);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    // 배열의 특정 구간 합을 세그먼트 트리로 구하기
    long sum(int node, int start, int end, int left, int right) {
        // 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하지 않는 경우 0리턴
        if (end < left || right < start) {
            return 0;
        } else if (left <= start && end <= right) {
            // 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하는 경우 노드 값 리턴
            return tree[node];
        } else {
            // 그 외는 2가지 경우가 존재
            // 1. 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 일부는 속하고 일부는 속하지 않는 경우
            // 2. 노드가 가지는 값의 구간이 구하려고 하는 합의 구간을 모두 포함하는 경우
            // 이와 같은 경우에는 자식노드를 탐색해서 값을 리턴
            return sum(node * 2, start, (start + end) / 2, left, right)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }
    }


    /**
     * 배열의 특정 인데스의 값이 변경 될 경우 세그먼트 트리의 노드 값 변경(차이 값을 더하는 방법)
     *
     * @param node  메서드가 실행되는 노드의 번호
     * @param start 노드가 가지는 합의 시작 인덱스
     * @param end   노드가 가지는 합의 끝 인덱스
     * @param index 값이 변경될 배열의 인덱스
     * @param diff  변경될 값 - 배열의 기존 값 = 차이 값
     */
    public void update(int node, int start, int end, int index, long diff) {
        // 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)가 포함되지 않을 경우
        if (index < start || end < index) {
        } else {
            // 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)가 포함되는 경우
            // 노드의 값 + 차이값(변경할 값-기존값)
            tree[node] = tree[node] + diff;

            // 노드가 리프노드가 아닌 경우
            if (start != end) {
                // 리프노드까지 계속 자식노드를 탐색
                update(node * 2, start, (start + end) / 2, index, diff);
                update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
            }
        }
    }

    /**
     * 배열의 특정 인데스의 값이 변경 될 경우 세그먼트 트리의 노드 값 변경(노드 값을 직접 변경)
     *
     * @param node        메서드가 실행되는 노드의 번호
     * @param start       노드가 가지는 합의 시작 인덱스
     * @param end         노드가 가지는 합의 끝 인덱스
     * @param index       값이 변경될 배열의 인덱스
     * @param changeValue 변경될 값
     */
    long update2(int node, int start, int end, int index, long changeValue) {
        // 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)가 포함되지 않을 경우
        if (index < start || end < index) {
            // 트리의 노드 값 리턴
            return tree[node];
        } else if (start == index && end == index) {
            // 노드가 가지는 값의 구간과 배열의 인덱스(값이 변경 될 인덱스)값이 같은 경우
            // 노드의 값을 변경 될 값으로 변경
            return tree[node] = changeValue;
        } else {
            // 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)값이 포함되는 경우(같은 경우는 제외)
            // 자식 노드를 탐색 후 값을 더해서 리턴
            return tree[node] = update2(node * 2, start, (start + end) / 2, index, changeValue) +
                    update2(node * 2 + 1, (start + end) / 2 + 1, end, index, changeValue);
        }
    }


}
