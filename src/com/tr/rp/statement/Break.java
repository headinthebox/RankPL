package com.tr.rp.statement;

import com.tr.rp.core.DStatement;
import com.tr.rp.core.VarStore;
import com.tr.rp.core.rankediterators.RankTransformIterator;
import com.tr.rp.core.rankediterators.RankedIterator;
import com.tr.rp.expressions.num.IntLiteral;
import com.tr.rp.expressions.num.NumExpression;
import com.tr.rp.expressions.num.Var;

/**
 * Terminates execution with run time exception
 */
public class Break implements DStatement {

	private String message;
	
	public Break(String message) {
		this.message = message;
	}
	
	@Override
	public RankedIterator getIterator(final RankedIterator in) {
		return new RankedIterator() {

			@Override
			public boolean next() {
				throw new RuntimeException(message);
			}

			@Override
			public VarStore getVarStore() {
				return null;
			}

			@Override
			public int getRank() {
				return 0;
			}
		};
	}
	
	public String toString() {
		return "Break :" + message;
	}
	
	public boolean equals(Object o) {
		return o instanceof Break && ((Break)o).message.equals(message);
	}

}
