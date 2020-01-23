package org.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ScriptExecutionOrder {

  /**
   * 1 -> 2,3,4 2 -> 4,6 4 -> 6
   *
   * @param args
   */

  public static void main(String[] args) {

    final String COMMA = ",";
    Scanner s = new Scanner(System.in);
    System.out.println("ENTER NUMBER OF INPUTS N: ");
    int N = s.nextInt();
    List<VulnerabilityScript> vulnerabilityScripts = new ArrayList<>();
    while (N-- > 0) {
      int scriptId = s.nextInt();
      List<Integer> dependencies = new ArrayList<>();
      for (String val : s.next().split(COMMA)) {
        dependencies.add(Integer.parseInt(val));
      }
      vulnerabilityScripts.add(new VulnerabilityScript(scriptId, dependencies));
    }

    List<Integer> executionOrder = getExecutionOrder(vulnerabilityScripts);
    int i = executionOrder.size() - 1;
    while (i >= 0) {
      System.out.print(executionOrder.get(i--) + " ");
    }
  }

  private static List<Integer> getExecutionOrder(List<VulnerabilityScript> vulnerabilityScripts) {
    Map<Integer, List<Integer>> scriptIdToDependencyMap = vulnerabilityScripts
        .stream()
        .collect(Collectors
            .toMap(VulnerabilityScript::getScriptId, VulnerabilityScript::getDependencies));
    if (Objects.isNull(vulnerabilityScripts) || vulnerabilityScripts.isEmpty()) {
      return Collections.emptyList();
    }

    Set<Integer> executionOrder = new LinkedHashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    Iterator<Map.Entry<Integer, List<Integer>>> iterator = scriptIdToDependencyMap.entrySet()
        .iterator();
    Map.Entry<Integer, List<Integer>> next = iterator.next();
    queue.add(next.getKey());
    while (!queue.isEmpty()) {
      Integer start = queue.remove();
      if (Objects.nonNull(scriptIdToDependencyMap.get(start))) {
        queue.add(start);
        for (Integer val : scriptIdToDependencyMap.get(start)) {
          queue.add(val);
        }
        scriptIdToDependencyMap.put(start, null);
      } else {
        executionOrder.add(start);
        scriptIdToDependencyMap.remove(start);
      }
    }
    List<Integer> result = new ArrayList<>(executionOrder);
    return result;
  }

  static class VulnerabilityScript {

    private final int scriptId;
    private final List<Integer> dependencies;

    public VulnerabilityScript(int scriptId, List<Integer> dependencies) {
      this.scriptId = scriptId;
      this.dependencies = dependencies;
    }

    public int getScriptId() {
      return scriptId;
    }

    public List<Integer> getDependencies() {
      return dependencies;
    }
  }
}

