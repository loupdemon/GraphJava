import java.util.Vector;
import java.util.Iterator;

public class GRAPH<E>
{
	NODE<E> source;

	public GRAPH(NODE<E> n)
	{
		source = n;
	}

	public int nbMin()
	{
		return source.nbPuitMin(source);
	}

	public int nbMax()
	{
		return source.nbPuitMax(source);
	}

	public void aff()
	{
		Vector<E> res = new Vector<E>();
		int i;
		source.affProf(source,res);
		for (i=0; i<res.size() - 1; i++)
			System.out.print(res.get(i) + ", ");
		System.out.println(res.get(i));
	}

	public void affLgr(Vector<NODE<E>> n, Vector<NODE<E>> res)
	{
		Vector<NODE<E>> next_node = new Vector<NODE<E>>();
		Iterator<NODE<E>> it = n.iterator();
		boolean put_brackets = false;
		boolean put_space = false;

		while (it.hasNext())
		{
			NODE<E> node = it.next();

			if (!res.contains(node))
			{
				if(!put_brackets)
				{
					put_brackets = true;
					System.out.print("(");
				}
				if (put_space)
					System.out.print(", ");
				else
					put_space = true;

				System.out.print(node.val);
				res.add(node);
			}
			Vector<NODE<E>> tab = node.succ;
			Iterator<NODE<E>> it2 = tab.iterator();

			while (it2.hasNext())
			{
				NODE<E> node2 = it2.next();
				next_node.add(node2);
			}
		}

		if (put_brackets)
			System.out.print(")");

		if(!next_node.isEmpty())
		{
			if (put_brackets)
				System.out.print(", ");
			affLgr(next_node, res);
		}
	}

	public void afg()
	{
		Vector<NODE<E>> res = new Vector<NODE<E>>();
		Vector<NODE<E>> n = new Vector<NODE<E>>();
		n.add(source);
		affLgr(n,res);
	}

	 public static void main(String[] args)
	  {
	        GRAPH<Integer> g;
	        NODE<Integer> n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14;
	        NODE<Integer> n15, n16;
	        n1 = new NODE<Integer>(1);
	        n2 = new NODE<Integer>(2);
	        n3 = new NODE<Integer>(3);
	        n4 = new NODE<Integer>(4);
	        n5 = new NODE<Integer>(5);
	        n6 = new NODE<Integer>(6);
	        n7 = new NODE<Integer>(7);
	        n8 = new NODE<Integer>(8);
	        n9 = new NODE<Integer>(9);
	        n10 = new NODE<Integer>(10);
	        n11 = new NODE<Integer>(11);
	        n12 = new NODE<Integer>(12);
	        n13 = new NODE<Integer>(13);
	        n14 = new NODE<Integer>(14);
	        n15 = new NODE<Integer>(15);
	        n16 = new NODE<Integer>(16);
	        g = new GRAPH<Integer>(n1);
	        n1.adjNoeud(n2);
	        n2.adjNoeud(n9);
	        n9.adjNoeud(n14);
	        n14.adjNoeud(n15);
	        n15.adjNoeud(n16);
	        n2.adjNoeud(n5);
	        n5.adjNoeud(n6);
	        n6.adjNoeud(n8);
	        n8.adjNoeud(n9);
	        n8.adjNoeud(n15);
	        n6.adjNoeud(n10);
	        n6.adjNoeud(n7);
	        n7.adjNoeud(n11);
	        n11.adjNoeud(n10);
	        n11.adjNoeud(n12);
	        n12.adjNoeud(n13);
	        n13.adjNoeud(n16);
	        n1.adjNoeud(n3);
	        n3.adjNoeud(n7);
	        n1.adjNoeud(n7);
	        n1.adjNoeud(n4);
	        n4.adjNoeud(n11);
	        System.out.println("Chemin le plus court = " + g.nbMin());
	        System.out.println("Chemin le plus long = " + g.nbMax());
	        System.out.print("parcours en profondeur : ");
					g.aff();
					System.out.print("parcours en largeur : ");
					g.afg();
	    }
	}
