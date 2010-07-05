package com.progress.codeshare.extension.count;

import net.sf.saxon.expr.XPathContext;

public final class CountExtension {
	private long count;
	private long initCount;

	public CountExtension(final long initCount) {
		count = initCount;

		this.initCount = initCount;
	}

	public long getCount(final XPathContext ctx) {
		return count;
	}

	public long next(final XPathContext ctx) {
		return next(ctx, false);
	}

	public long next(final XPathContext ctx, final boolean resetFlag) {

		/* Ensure that Long.MAX_VALUE is higher than the count */
		if (Long.MAX_VALUE > count)
			++count;
		else
			count = initCount;

		return count;
	}

	public long previous(final XPathContext ctx) {
		return previous(ctx, false);
	}

	public long previous(final XPathContext ctx, final boolean resetFlag) {

		/* Ensure that initCount is lower than the count */
		if (initCount < count)
			--count;
		else
			count = initCount;

		return count;
	}

}