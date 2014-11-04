package com.chaoshi.structure;

public class Tuple {
	static public class TowTuple<A, B> {
		public final A one;
		public final B tow;

		public TowTuple(A one, B tow) {
			this.one = one;
			this.tow = tow;
		}
	}
	
	static public class ThreeTuples<A, B, C> extends TowTuple<A,B> {
		public final C three;
		public ThreeTuples(A one, B tow, C three) {
			super(one, tow);
			this.three = three;
		}
	}
	
	static public class FourTuples<A, B, C, D> extends ThreeTuples<A, B, C> {
		public final D four;
		public FourTuples(A one, B tow, C three,D four) {
			super(one, tow, three);
			this.four = four;
		}
	}
	
}


