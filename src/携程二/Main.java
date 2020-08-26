package 携程二;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;
    static int maxRes = 0;
    public static Integer dfs(WorkflowNode head){
        if(head.nextNodes == null)
            return 0;
        List<WorkflowNode> nextNodesList = head.nextNodes;
        int[] values = new int[nextNodesList.size()];
        for(int i=0;i<nextNodesList.size();i++){
//            cur = head.timeoutMillis+nextNodesList.get(i).timeoutMillis;
//            dfs(nextNodesList.get(i), cur);
//            maxRes = Math.max(maxRes, cur);
            values[i] += dfs(nextNodesList.get(i));
        }
        Arrays.sort(values);
        return values[values.length-1]+head.timeoutMillis;

    }
    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);

        for (String nodeValue : value.split("\\|")) {
            String[] properties = nodeValue.split("\\`");
            WorkflowNode node = map.get(properties[0]);

            node.timeoutMillis = Integer.parseInt(properties[1]);
            node.initialised = true;

            // Check next nodes
            if (properties[2].equals("END")) {
                continue;
            }
            node.nextNodes = Arrays.stream(properties[2].split(","))
                    .map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));

            map.put(node.nodeId, node);
        }

        return head;
    }

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            WorkflowNode node = WorkflowNode.load(cin.next());
            System.out.println(WorkflowNode.dfs(node));
        }
    }
}