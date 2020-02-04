package data;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Rhadryn
 */
public class Index {
    /**The name of the index, e.g. Isaiah, 63*/
    private String name;
    /**The number value of the index*/
    private int order;
    /**Links to the child indices*/
    private ArrayList<Index> children;

    public Index(String name) {
        this.name = name;
        children = new ArrayList<Index>();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Index other = (Index) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public ArrayList<Index> getChildren() {
        return children;
    }
}
