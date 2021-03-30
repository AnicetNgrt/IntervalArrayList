package anicet.intervalutils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntervalArrayList {
	
	private List<ArrayList<Integer>> l;
	
	public IntervalArrayList() {
		l = new ArrayList<ArrayList<Integer>>();
	}
	
	public void addInRange(int n) {
		int i = 0;
		for(ArrayList<Integer> interval: l) {
			int inf = interval.get(0);
			int sup = interval.get(1);
			
			if(n == sup + 1) {
				interval.set(1, n);
				return;
			} else if(n == inf - 1) {
				interval.set(0, n);
				return;
			} else if(n < inf) {
				List<ArrayList<Integer>> newInBetween = new ArrayList<ArrayList<Integer>>();
				ArrayList<Integer> isolated = new ArrayList<Integer>();
				isolated.add(n);
				isolated.add(n);
				newInBetween.add(isolated);
				l = join(l.subList(0, i), newInBetween, l.subList(i, l.size()));
				return;
			} else if(n >= inf && n <= sup) {
				return;
			}
			i++;
		}
		
		ArrayList<Integer> interval = new ArrayList<Integer>();
		interval.add(n);
		interval.add(n);
		l.add(interval);
	}
	
	public void removeFromRange(int n) {
		int i = 0;
		for(ArrayList<Integer> interval: l) {
			int inf = interval.get(0);
			int sup = interval.get(1);
			
			if(n == inf && n == sup) {
				l = join(l.subList(0, i), l.subList(i + 1, l.size()));
				return;
			} else if(n == sup) {
				interval.set(1, sup - 1);
				return;
			} else if(n == inf) {
				interval.set(0, inf + 1);
				return;
			} else if(n < sup && n > inf) {
				List<ArrayList<Integer>> newInBetween = new ArrayList<ArrayList<Integer>>();
				ArrayList<Integer> part1 = new ArrayList<Integer>();
				part1.add(inf);
				part1.add(n-1);
				ArrayList<Integer> part2 = new ArrayList<Integer>();
				part2.add(n+1);
				part2.add(sup);
				newInBetween.add(part1);
				newInBetween.add(part2);
				l = join(l.subList(0, i), newInBetween, l.subList(i + 1, l.size()));
				return;
			}
			
			i++;
		}
	}
	
	@SafeVarargs
	private static ArrayList<ArrayList<Integer>> join(List<ArrayList<Integer>>...parts) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		for(List<ArrayList<Integer>> p: parts) {
			for(ArrayList<Integer> interval: p) {
				res.add(interval);
			}
		}
		
		return res;
	}
	
	public static IntervalArrayList fromString(String text) {
		IntervalArrayList res = new IntervalArrayList();
		String[] parts = text.split("\\s+");
		
		int i = 0;
		for(String p: parts) {
			if(i % 2 == 0) {
				res.l.add(new ArrayList<Integer>());
			}
			res.l.get(res.l.size() - 1).add(Integer.parseInt(p));
			i++;
		}
		
		return res;
	}
	
	public ArrayList<Integer> toRange() {
		ArrayList<Integer> range = new ArrayList<Integer>();
		
		for(ArrayList<Integer> interval: l) {
			int inf = interval.get(0);
			int sup = interval.get(1);
			
			if(inf == sup) {
				range.add(inf);
			} else {
				for(int i = inf; i <= sup; i++) {
					range.add(i);
				}
			}
		}
		
		return range;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(ArrayList<Integer> interval: l) {
			for(int b: interval) {
				sb.append(b);
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
	
	public String toStringPretty() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(ArrayList<Integer> interval: l) {
			sb.append("[");
			sb.append(interval.get(0));
			sb.append(", ");
			sb.append(interval.get(1));
			sb.append("], ");
		}
		String res = sb.toString();
		res = res.substring(0, res.length() - 2);
		return res + "]";
	}

}
