package a_Array.e_Contain_Find_And_Remove;

public class Array {
    private int[] data;
    private int size;

    /**
     * 传入数组的容量capacity构造Array
     * @param capacity 数组的容量
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组容量
     * @return int 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     * @return int 组中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     * @return boolean 数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在索引为 index 位置插入一个元素
     * @param index 需要插入的位置
     * @param e 需要插入的元素
     */
    public void add(int index, int e){
        if (size == data.length){
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        // 每次添加元素，该元素之后的元素都向后移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // 设置该位置元素值为e
        data[index] = e;
        size ++;
    }

    /**
     * 数组末尾添加元素 e
     * @param e 需要添加的元素
     */
    public void addLast(int e){
        add(size, e);
    }

    /**
     * 数组开头添加元素 e
     * @param e 需要添加的元素
     */
    public void addFirst(int e){
        add(0, e);
    }

    /**
     * 获取 index 位置的元素
     * @param index 想获取元素的位置
     * @return 想获取的元素
     */
    public int get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改 index 位置的元素
     * @param index 想修改元素的位置
     * @param e 想修改的元素值
     */
    public void set(int index, int e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
    }

    /**
     * 遍历数组，判断是否又元素e
     * @param e 需要判断的元素e
     * @return boolean 是否存在该元素
     */
    public boolean contains(int e){
        for (int i = 0; i < size; i++) {
            if (data[i]  == e){
                return true;
            }
        }
        return false;
    }

    /**
     * 遍历数组，查找元素 e 的索引，如果不存在就返回-1
     * @param e 需要查找索引的元素
     * @return int 该元素的索引
     */
    public int find(int e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除 index 位置的元素，并返回被删除的元素
     * @param index 需要删除元素的索引
     * @return int 被删除的元素
     */
    public int remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        int ret = data[index];
        // 移除该元素，相当于后边的元素全部前移一位
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size --;
        return ret;
    }

    /**
     * 从数组中删除第一个元素，并返回被删除的元素
     * @return
     */
    public int removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，并返回被删除的元素
     * @return
     */
    public int reomveLast(){
        return remove(size - 1);
    }

    /**
     * 从数组中删除指定的元素
     */
    public void removeElement(int e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
