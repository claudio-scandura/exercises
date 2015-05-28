package exercises.graphs;

/**
 * Created by cls on 12/03/15.
 */
public class WeightedEdge implements Comparable<WeightedEdge> {

    int from, to, weight;

    public WeightedEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public WeightedEdge(int from, int to) {
        this.from = from;
        this.to = to;
        this.weight = 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof  WeightedEdge)) return false;
        WeightedEdge other = (WeightedEdge) obj;
        return this.weight == other.weight && (
                (this.from == other.from && this.to == other.to) ||
                        (this.to == other.from && this.from == other.to)
                );
    }

    @Override
    public int hashCode() {
        return from + to + weight;
    }

    @Override
    public int compareTo(WeightedEdge o) {
        return this.weight - o.weight;
    }
}
