	static ArrayList<HashSet<Integer>> divisores(int n){
		ArrayList<HashSet<Integer>> div = new ArrayList<HashSet<Integer>>(n+1);
		div.add(0, null);
		div.add(1, new HashSet<Integer>());
		div.get(1).add(1);
		for (int i = 2; i <= n; i++) {
			int j=2;
			div.add(i, new HashSet<Integer>());
			div.get(i).add(1);
			while(j<=Math.sqrt(i)){
				if(i%j==0){
					div.get(i).add(j);
					div.get(i).add(i/j);
					HashSet<Integer> A = div.get(j);
					HashSet<Integer> B = div.get(i/j);
					for(Integer a:A){
						div.get(i).add(a);
						for(Integer b:B)
							div.get(i).add(a*b);
					}
					for(Integer b:B)
						div.get(i).add(b);
					break;
				}
				j++;
			}
			div.get(i).add(i);
		}
		return div;
	}