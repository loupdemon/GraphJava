import java.util.Vector;

public class NODE<E>
{
	E val;
	Vector <NODE<E>> succ;

	public NODE(E v)
	{
		val = v;
		succ = new Vector<NODE<E>>();
	}

	public void adjNoeud(NODE<E> id)
	{
		succ.add((NODE<E>) id);
	}

	public int nbPuitMin(NODE<E> n)
	{
		int lgr = n.succ.size();
		int min = -1;
		int tmp;
		if (lgr == 0)
			return 0;

		for (int i = 0; i < lgr; i++)
		{
			tmp = this.succ.get(i).nbPuitMin(this.succ.get(i));
			if (tmp != -1 && (min == -1 || min > tmp))
				min = tmp;
		}

		if (min != -1)
			return min+1;

		else
			return -1;
	}

	public int nbPuitMax(NODE<E> n)
	{
		int lgr = n.succ.size();
		int max = -1;
		int tmp;
		if (lgr == 0)
			return 0;

		for (int i = 0; i < lgr; i++)
		{
			tmp = this.succ.get(i).nbPuitMax(this.succ.get(i));
			if (tmp != -1 && (max == -1 || max < tmp))
				max= tmp;
		}

		if (max != -1)
			return max+1;

		else
			return -1;
	}

	public void affProf(NODE<E> n, Vector<E> res)
	{
		int lgr = n.succ.size();
		res.add(this.val);
		for (int i = 0; i<lgr; i++)
		{
			if (!res.contains(this.succ.get(i).val))
				this.succ.get(i).affProf(this.succ.get(i),res);
		}
	}
}
