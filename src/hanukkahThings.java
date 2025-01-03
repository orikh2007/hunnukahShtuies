public class hanukkahThings {

    public static boolean exists(Queue<Integer> q, int n) {
        Queue<Integer> a = copy(q);
        int num;
        while (!a.isEmpty()) {
            num = a.remove();
            if (num == n) {
                return true;
            }
        }
        return false;
    }

    public static<T> Queue<T> copy(Queue<T> q)
    {
        Queue<T> c = new Queue<>(), a = new Queue<>();
        T n;
        while(!q.isEmpty())
        {
            n=q.remove();
            c.insert(n);
            a.insert(n);
        }
        while(!a.isEmpty())
        {
            q.insert(a.remove());
        }
        return c;
    }

    public static<T> void spilledOn(Queue<T> src, Queue<T> dst)
    {
        while(!src.isEmpty())
        {
            dst.insert(src.remove());
        }
    }

    public static void insertSorted(Queue<Integer> q, int x)
    {
        Queue<Integer> a = new Queue<>();
        while(!q.isEmpty() && q.head()<x)
            a.insert(q.remove());
        a.insert(x);
        spilledOn(q, a);
        spilledOn(a, q);
    }

    public static boolean startsWith(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> w1 = copy(q1);
        Queue<Integer> w2 = copy(q2);
        while (!w1.isEmpty() && !w2.isEmpty()) {
            if (w1.remove() != w2.remove())
                return false;
        }
        return w2.isEmpty();
    }

    public static boolean quest2(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> w1 = copy(q1);
        Queue<Integer> w2 = copy(q2);
        while (!w1.isEmpty() && !w2.isEmpty()) {
            if (startsWith(w1, w2))
                return true;
            w1.remove();
        }
        return false;
    }

    public static boolean startsWithSum(Queue<Integer> q1, int x) {
        Queue<Integer> w1 = copy(q1);
        int sum = 0;
        while (!w1.isEmpty() && x > sum) {
            sum += w1.remove();
            if (sum == x)
                return true;
        }
        return false;
    }

    public static boolean quest4(Queue<Integer> q1, int x) {
        Queue<Integer> w1 = copy(q1);
        while (!w1.isEmpty()) {
            if (startsWithSum(w1, x))
                return true;
            w1.remove();
        }
        return false;
    }

    public static void sort(Queue<Integer> q)
    {
        Queue<Integer> w = new Queue<>();
        while(!q.isEmpty())
        {
            insertSorted(w, q.remove());
        }
        spilledOn(w, q);
    }
    public static int quest6(Queue<Integer> q1, Queue<Integer> q2)
    {
        Queue<Integer> w1 = copy(q1);
        Queue<Integer> w2 = copy(q2);
        sort(w1);
        while(!w1.isEmpty()&&!w2.isEmpty())
        {
            if(!exists(w2, w1.head()))
                return w1.remove();
            w1.remove();
        }
        return -1;
    }

    public static int quest8(Queue<Integer> q) {
        if (q.isEmpty()) {
            return 0;
        }

        int shortLen = Integer.MAX_VALUE, shortSum = 0, sum=0, len, num;

        Queue<Integer> w = copy(q);

        while(!w.isEmpty())
        {
            num = w.remove();
            len = 1;
            sum+=num;
            while(!w.isEmpty()&&num<w.head())
            {
                num = w.remove();
                len++;
                sum+=num;
            }
            if(len<shortLen) {
                shortSum = sum;
                shortLen = len;
            }
            sum = 0;
        }
        return shortSum;
    }

    public static void quest10(Queue<Integer> q)
    {
        Queue<Integer> res = new Queue<>();
        int min;
        while(!q.isEmpty())
        {
            min = q.remove();
            for(int i = 0; i<2; i++)
            {
                if(q.head()<min)
                    min = q.head();
                q.remove();
            }
            res.insert(min);
        }
        spilledOn(res, q);
    }

    public static<T> int numOfRepetitions(Queue<T> q, T x)
    {
        int c = 0;
        Queue<T> w = copy(q);
        while(!w.isEmpty())
        {
            if(w.head()==x)
                c++;
            w.remove();
        }
        return c;
    }
    public static<T> void removeRepetitions(Queue<T> q, T x)
    {
        Queue<T> w = new Queue<>();
        while(!q.isEmpty())
        {
            if(q.head()!=x)
                w.insert(q.head());
            q.remove();
        }
        spilledOn(w, q);
    }
    public static Queue<Integer> quest12(Queue<Integer> q)
    {
        Queue<Integer> w = copy(q), res = new Queue<>();
        int n;
        while(!w.isEmpty())
        {
            n = w.remove();
            res.insert(n);
            res.insert(numOfRepetitions(q, n));
            removeRepetitions(w, n);
        }
        return res;
    }


    public static void main(String[] args) {
        Queue<Integer> q1 = new Queue<>();
        Queue<Integer> q2 = new Queue<>();
        Queue<Integer> q3 = new Queue<>();
        q1.insert(9);
        q1.insert(6);
        q1.insert(2);
        q1.insert(3);
        q1.insert(1);
        q1.insert(3);
        q2.insert(2);
        q2.insert(3);
        q2.insert(6);
        q2.insert(5);
        q2.insert(7);
        q2.insert(4);
        q2.insert(9);
        q3.insert(3);
        q3.insert(2);
        q3.insert(8);
        q3.insert(4);
        q3.insert(6);
        q3.insert(7);
        q3.insert(9);
        q3.insert(7);
        q3.insert(4);
        System.out.println(quest2(q1, q2));
        System.out.println(quest4(q1, 8));
        sort(q1);
        System.out.println(q1);
        System.out.println(quest6(q1, q2));
        System.out.println(quest8(q2));
        Queue<Integer> q4 = copy(q3);
        quest10(q3);
        System.out.println(q3);
        System.out.println(quest12(q4));
    }

}
