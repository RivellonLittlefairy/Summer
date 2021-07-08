import java.util.*;
/*
  有大模拟那味儿了
  大概是对集合框架的综合运用
  不大明白的地方：
  TreeSet的排序性质
  TreeSet构造函数传入一个Lambda可以比较大小
 */
public class 点菜展示表 {
    public static void main(String[] args) {

        List<List<String>> lis=new LinkedList<>();
        List<String> l1=new LinkedList<String>();
        l1.add("David");
        l1.add("3");
        l1.add("Ceviche");
        lis.add(l1);

        七月六日 c1 = new 七月六日();
        System.out.println(c1.displayTable(lis));
    }
}
/*
给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，
而 foodItemi 是客户点的餐品名称。
请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，
第一列应当填对应的桌号，后面依次填写下单的餐品数量。
注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。

*/
class 七月六日 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        HashMap<String,Integer> map=new HashMap<>();
        Set<String> set=new TreeSet<>((o1, o2) -> o1.compareTo(o2));
        Set<Integer> table=new TreeSet<>((o1, o2) -> o1.compareTo(o2));
        List<String> lis=new LinkedList<>();
        for(List<String> ding:orders){
            table.add(Integer.valueOf(ding.get(1)));
            set.add(ding.get(2));
            if(map.containsKey(ding.get(1)+ding.get(2))){
                map.put(ding.get(1)+ding.get(2),1+map.get(ding.get(1)+ding.get(2)));
            }else{
                map.put(ding.get(1)+ding.get(2),1);
            }
        }
        for(String str:set){
            lis.add(str);
        }
        List<String> fir=new LinkedList<>();
        fir.add("Table");
        fir.addAll(lis);
        List<List<String>> res=new LinkedList<>();
        res.add(fir);
        for(int i:table){
            List<String> temp =new LinkedList<>();
            temp.add(i+"");
            for(int j=0;j<lis.size();j++){
                int num= map.containsKey(i+lis.get(j))?map.get(i+lis.get(j)):0;
                temp.add(num+"");
            }
            res.add(temp);
        }
        return res;
    }
}
