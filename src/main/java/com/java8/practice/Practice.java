package com.java8.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Notes {
    Integer id;
    String tagName;
    Integer tagId;

    public Notes(Integer id, String tagName, Integer tagId) {
        this.id = id;
        this.tagName = tagName;
        this.tagId = tagId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}
public class Practice {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32,8,10);

        //even numebrs
        Predicate<Integer> predicate = x -> x%2==0;

        List<Integer> ans =list.stream().filter(x->x%2==0).collect(Collectors.toList());
        list.stream().filter(predicate).forEach(System.out::println);
        System.out.println("****************************");
        ans.stream().forEach(System.out::println);

        System.out.println("****************************");

        List<Integer> res =list.stream().map(x->x+"").filter(s->s.startsWith("1")).map(x->Integer.valueOf(x)).collect(Collectors.toList());

        res.stream().forEach(System.out::println);

        //find duplicates
        System.out.println("****************************");

        HashSet<Integer> set = new HashSet<Integer>();
        list.stream().filter(s->!set.add(s)).forEach(System.out::println);


        //find first element

        Optional<Integer> rs =list.stream().findFirst();
        System.out.println(rs);
        //or
        list.stream().findFirst().ifPresent(System.out::println);

        //count number of elements
        System.out.println("****************************");
        System.out.println(list.stream().count());
        //max value present in stream
        System.out.println("****************************");
        Integer maxvalue= list.stream().max(Integer::compare).get();
        System.out.println(maxvalue);

        String input = "Java articles are Awesome";
        //HashSet<Character,Integer> set = new HashSet<>();
        //find first non repeating character

        Character ans1 = input.chars()
                .mapToObj(s-> Character.toLowerCase(Character.valueOf((char) s))).
                collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue()==1)
                .map(key->key.getKey()).findFirst().get();

        System.out.println(ans1);
        //find first repeated character
         Character ans2 = input.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))
                 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet()
                 .stream().filter(entry-> entry.getValue()>1).map(key-> key.getKey()).findFirst().get();
        System.out.println(ans2);

        //sort the list
        System.out.println("****************************");
        list.stream().sorted().forEach(System.out::println);
        //sort in descending order
        System.out.println("****************************");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        //
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");


        Stream<String> stream = Stream.concat(list1.stream(),list2.stream());
        stream.forEach(System.out::println);


        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));

        noteLst.add(new Notes(6, "note4", 66));
       // Function<Integer,Integer> function = (x) -> x+2;
        Map<String,Integer> notesRecords = noteLst.stream()
                .sorted(Comparator
                        .comparingLong(Notes::getTagId)
                        .reversed())
                .collect(Collectors.toMap
                        (Notes::getTagName,Notes::getTagId,(oldValue,newValue) -> oldValue,LinkedHashMap::new));


        System.out.println("Notes : " + notesRecords);

        //count word/string

        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");


        Map<String,Long> map = names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(map);

        Optional.ofNullable(noteLst).orElseGet(Collections::emptyList).stream().filter(Objects::nonNull).map(notes -> notes.getTagName()).forEach(System.out::println);

        int arr[][] = new int[5][2];
        arr[0][0]=4345;
        arr[0][1]=35345;
        arr[1][0]=4366345;
        arr[1][1]=3536345;
        arr[2][0]=435345;
        arr[2][1]=8635345;
        arr[3][0]=4342345;
        arr[3][1]=7435345;
        arr[4][0]=4325345;
        arr[4][1]=64735345;

        Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i][0]+"******"+arr[i][1]);
        }
        //System.out.println(arr[0].length);

        Integer arr2[]={34,46,23,53};
        Arrays.sort(arr2, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                System.out.println(a+"*****"+b);
                return a-b;
            }
        });

        for (Integer val:arr2){
            System.out.println(val);
        }

        String str[] = {"deepak","prajapati"};

        List<String> resultString = Arrays.stream(str).map(w->w.split("")).flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList());
        resultString.stream().forEach(System.out::println);

        //Collections.sort(str ,Comparator);

    }

}
