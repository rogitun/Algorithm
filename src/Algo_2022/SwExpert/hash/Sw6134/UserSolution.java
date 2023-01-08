package Algo_2022.SwExpert.hash.Sw6134;

import java.util.*;

class UserSolution {

    String[] fields = {"NAME", "NUMBER", "BIRTHDAY", "EMAIL", "MEMO"};

    static class Entity {
        String pk;
        String name;
        String number;
        String birth;
        String email;
        String memo;

        public Entity(String pk, String name, String number, String birth, String email, String memo) {
            this.pk = pk;
            this.name = name;
            this.number = number;
            this.birth = birth;
            this.email = email;
            this.memo = memo;
        }
    }
    static class exValue{
        String pk;
        String exValue;

        public exValue(String pk, String exValue) {
            this.pk = pk;
            this.exValue = exValue;
        }
    }

    private Map<String, List<String>> nameIdx;
    private Map<String, List<String>> numberIdx;
    private Map<String, List<String>> birthIdx;
    private Map<String, List<String>> mailIdx;
    private Map<String, List<String>> memoIdx;
    private HashMap<String, Entity> entityMap;
    private int seq;

    //String으로 변환한 char 배열은 동일한 hashCode를 보여준다.
    void InitDB() {
        nameIdx = new HashMap<>();
        numberIdx = new HashMap<>();
        birthIdx = new HashMap<>();
        mailIdx = new HashMap<>();
        memoIdx = new HashMap<>();
        entityMap = new HashMap<>();
        seq = 1;
    }

    void Add(String name, String number, String birthday, String email, String memo) {
     //   System.out.println(name + " " + number + " " + birthday + " " + email + " " + memo);
        String pk = Integer.toString(seq);
        Entity newEntity = new Entity(pk, name, number, birthday, email, memo);
        makeIndex(name, pk, 0);
        makeIndex(number, pk, 1);
        makeIndex(birthday, pk, 2);
        makeIndex(email, pk, 3);
        makeIndex(memo, pk, 4);
        entityMap.put(pk, newEntity);
        seq++;
    }

    private void makeIndex(String name, String pk, int num) {
        switch (num) {
            case 0:
                if (nameIdx.getOrDefault(name, null) == null) {
                    List<String> al = new LinkedList<>();
                    al.add(pk);
                    nameIdx.put(name, al);
                } else {
                    List<String> list = nameIdx.get(name);
                    list.add(pk);
                }
                break;
            case 1:
                if (numberIdx.getOrDefault(name, null) == null) {
                    List<String> al = new LinkedList<>();
                    al.add(pk);
                    numberIdx.put(name, al);
                } else {
                    List<String> list = numberIdx.get(name);
                    list.add(pk);
                }
                break;
            case 2:
                if (birthIdx.getOrDefault(name, null) == null) {
                    List<String> al = new LinkedList<>();
                    al.add(pk);
                    birthIdx.put(name, al);
                } else {
                    List<String> list = birthIdx.get(name);
                    list.add(pk);
                }
                break;
            case 3:
                if (mailIdx.getOrDefault(name, null) == null) {
                    List<String> al = new LinkedList<>();
                    al.add(pk);
                    mailIdx.put(name, al);
                } else {
                    List<String> list = mailIdx.get(name);
                    list.add(pk);
                }
                break;
            case 4:
                if (memoIdx.getOrDefault(name, null) == null) {
                    List<String> al = new LinkedList<>();
                    al.add(pk);
                    memoIdx.put(name, al);
                } else {
                    List<String> list = memoIdx.get(name);
                    list.add(pk);
                }
                break;
        }
    }


    int Delete(int field, String str) {
     //   System.out.print("del : ");
       // System.out.println(fields[field] + " " + str);

        //해당 field의 인덱스에서 pk모음 가져온다
        List<String> list = findPrimaryKey(field, str);
        if (list == null) return 0;

        List<Entity> delPk = new LinkedList<>();
        int result = 0;
        //그 pk를 가진 엔티티 탐색하면서 인덱스에서 지워주고 엔티티맵에서 지워준다.
        //name, number, email, memo, birth에서 다 지웠어야함
        for (String s : list) {
            //  System.out.println("del entitiy : " + entityMap.get(s).name);
            Entity entity = entityMap.get(s);
            delPk.add(entity);
            entityMap.remove(s);
            result++;
        }
        deleteAll(str, delPk);
     //   System.out.println("del : " + result);
        return result;
    }

    private void deleteAll(String str, List<Entity> delPk) {
        for (Entity e : delPk) {
            //엔티티의 값이 필요함.
            List<String> list = nameIdx.get(e.name);
            list.remove(e.pk);

            list = numberIdx.get(e.number);
            list.remove(e.pk);

            list = birthIdx.get(e.birth);
            list.remove(e.pk);

           list = mailIdx.get(e.email);
            list.remove(e.pk);

           list = memoIdx.get(e.memo);
            list.remove(e.pk);

        }
    }

    private List<String> findPrimaryKey(int field, String str) {
        switch (field) {
            case 0:
                return nameIdx.getOrDefault(str, null);
            case 1:
                return numberIdx.getOrDefault(str, null);
            case 2:
                return birthIdx.getOrDefault(str, null);
            case 3:
                return mailIdx.getOrDefault(str, null);
            case 4:
                return memoIdx.getOrDefault(str, null);
            default:
                return null;
        }
    }


    //1번 -> 해당 엔티티 찾아서 삭제해버림 (index에서 str 삭제)
    //2번 -> 새로운 엔티티 만들어서 hash에 추가함.
    int Change(int field, String str, int changefield, String changestr) {
       // System.out.print("change : ");
      //  System.out.println(fields[field] + " " + str + " " + fields[changefield] + " " + changestr);
        List<String> list = findPrimaryKey(field, str);
        if (list == null) {
        //    System.out.println("change Fail");
            return 0;
        }

        List<exValue> targets = new LinkedList<>();
        int result = 0;
        for (String s : list) {
            Entity entity = entityMap.get(s);
            if (entity == null) continue;
            Entity target = findEntity(field, str, entity);
            if (target != null) {
                //pk와 ex value가 필요함
                String ex = addNewIdx(changefield, target, changestr);
                result++;
                targets.add(new exValue(target.pk,ex));
            }
        }
        removeIdx(changefield, targets);


      //  System.out.println("change : " + result);
        return result;
    }

    private void removeIdx(int changefield, List<exValue> targets) {
        List<String> list;
        for (exValue ex : targets) {
            switch (changefield) {
                case 0:
                    list = nameIdx.get(ex.exValue);
                    list.remove(ex.pk);
                    break;
                case 1:
                    list = numberIdx.get(ex.exValue);
                    list.remove(ex.pk);
                    break;
                case 2:
                    list = birthIdx.get(ex.exValue);
                    list.remove(ex.pk);
                    break;
                case 3:
                    list = mailIdx.get(ex.exValue);
                    list.remove(ex.pk);
                    break;
                case 4:
                   list = memoIdx.get(ex.exValue);
                    list.remove(ex.pk);
                    break;
                default:
                    break;
            }
        }
    }

    private Entity findEntity(int field, String str, Entity entity) {
        switch (field) {
            case 0:
                if (entity.name.equals(str))
                    return entity;
            case 1:
                if (entity.number.equals(str))
                    return entity;
            case 2:
                if (entity.birth.equals(str))
                    return entity;
            case 3:
                if (entity.email.equals(str))
                    return entity;
            case 4:
                if (entity.memo.equals(str))
                    return entity;
            default:
                return null;
        }
    }

    //changefield로 어떤 필드 변경인지 찾고,
    //그 필드에서 현재 entity의 idx 지우고
    //새로운 값을 등록한다.

    //2, entity, 19520624
    private String addNewIdx(int changefield, Entity entity, String changestr) {
        String ex=null;
        switch (changefield) {
            case 0:
                ex = entity.name;
                entity.name = changestr;
                makeIndex(entity.name, entity.pk, 0);
                break;
            case 1:
                ex = entity.number;
                entity.number = changestr;
                makeIndex(entity.number, entity.pk, 1);
                break;
            case 2:
                ex = entity.birth;
                entity.birth = changestr;
                makeIndex(entity.birth, entity.pk, 2);
                break;
            case 3:
                ex = entity.email;
                entity.email = changestr;
                makeIndex(entity.email, entity.pk, 3);
                break;
            case 4:
                ex = entity.memo;
                entity.memo = changestr;
                makeIndex(entity.memo, entity.pk, 4);
                break;
            default:
                break;
        }
        return ex;
    }

    //찾고자 하는 필드, 일치하는 값, 반환필드
    Solution.Result Search(int field, String str, int returnfield) {
      //  System.out.print("search : ");
     //   System.out.println(fields[field] + " " + str + " " + fields[returnfield]);
        Solution.Result result = new Solution.Result();

        List<String> list = findPrimaryKey(field, str);
        if (list == null) result.count = 0;
        else {
            if (list.size() == 1) {
                result.count = 1;
                String pk = list.get(0);
                Entity entity = entityMap.get(pk);
                if (entity == null) {
                    result.count = 0;

                } else {
                    result.count = 1;
                    result.str = findAttr(entity, returnfield);
                }
            } else {
                result.count = list.size();
            }
        }
      //  System.out.println("result : " + result.str + " " + result.count);
        return result;
    }

    private String findAttr(Entity entity, int returnfield) {
        switch (returnfield) {
            case 0:
                return entity.name;
            case 1:
                return entity.number;
            case 2:
                return entity.birth;
            case 3:
                return entity.email;
            case 4:
                return entity.memo;
            default:
                return null;
        }
    }
}

