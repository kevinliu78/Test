package com.kevin.test;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestPrioritySort {

    public static void main(String[] args) {
        List<FilterPolicy> list = new ArrayList<FilterPolicy>();
        list.add(new FilterPolicy(0, "aaa"));
        list.add(new FilterPolicy(0, "bbb"));
        list.add(new FilterPolicy(2, "ccc"));
        list.add(new FilterPolicy(1, "ddd"));
        list.add(new FilterPolicy(3, "eee"));
        System.out.println("=================11111111111111========================");
        for (FilterPolicy filterPolicy : list) {
            System.out.println(filterPolicy.toString());
        }
        Collections.sort(list);
        System.out.println("=================22222222222222========================");
        for (FilterPolicy filterPolicy : list) {
            System.out.println(filterPolicy.toString());
        }
    }


    static class FilterPolicy implements Comparable<FilterPolicy> {
        private int priority;
        private String featureCode;


        public FilterPolicy(int priority, String featureCode) {
            super();
            this.priority = priority;
            this.featureCode = featureCode;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getFeatureCode() {
            return featureCode;
        }

        public void setFeatureCode(String featureCode) {
            this.featureCode = featureCode;
        }

        @Override
        public int compareTo(FilterPolicy fp) {
            if (this.getPriority() == fp.getPriority())
                return 0;
            else if (this.getPriority() > fp.getPriority()) {
                return 1;
            } else {
                return -1;
            }
            //return this.priority - fp.getPriority();
        }

        @Override
        public String toString() {
            return "FilterPolicy [priority=" + priority + ", featureCode=" + featureCode + "]";
        }


    }


    public void listSort(List<ObjectNode> list, String sortColumn,
                         String order) {
        Collections.sort(list, (o1, o2) -> {
            if (sortColumn != null && !sortColumn.isEmpty()) {
                if ("mac".equals(sortColumn)) {
                    if ("desc".equals(order)) {
                        return new String(o2.get(sortColumn).asText()).compareTo(new String(o1.get(sortColumn).asText()));
                    } else {
                        return new String(o1.get(sortColumn).asText()).compareTo(new String(o2.get(sortColumn).asText()));
                    }
                } else if ("address".equals(sortColumn)) {
                    if ("desc".equals(order)) {
                        if ((o2.get("orderAddress").asText()).equals(o1.get("orderAddress").asText())) {
                            if (o2.get("floorNo").asInt() == (o1.get("floorNo").asInt())) {
                                if (o1.get("mtrStatus").asInt() == 1 && o2.get("mtrStatus").asInt() == 1) {
                                    return o2.get("houseNo").asInt() - o1.get("houseNo").asInt();
                                } else {
                                    if ((o1.get("mtr").asDouble()) == (o2.get("mtr").asDouble())) {
                                        return o2.get("houseNo").asInt() - o1.get("houseNo").asInt();
                                    } else {
                                        return new Double(o1.get("mtr").asDouble()).compareTo(new Double(o2.get("mtr").asDouble()));
                                    }
                                }
                            } else {
                                return o2.get("floorNo").asInt() - o1.get("floorNo").asInt();
                            }
                        } else {
                            return new String(o2.get("orderAddress").asText()).compareTo(new String(o1.get("orderAddress").asText()));
                        }
                    } else {
                        if ((o1.get("orderAddress").asText()).equals(o2.get("orderAddress").asText())) {
                            if (o1.get("floorNo").asInt() == (o2.get("floorNo").asInt())) {
                                if (o1.get("mtrStatus").asInt() == 1 && o2.get("mtrStatus").asInt() == 1) {
                                    return o1.get("houseNo").asInt() - o2.get("houseNo").asInt();
                                } else {
                                    if ((o1.get("mtr").asDouble()) == (o2.get("mtr").asDouble())) {
                                        return o1.get("houseNo").asInt() - o2.get("houseNo").asInt();
                                    } else {
                                        return new Double(o1.get("mtr").asDouble()).compareTo(new Double(o2.get("mtr").asDouble()));
                                    }
                                }
                            } else {
                                return o1.get("floorNo").asInt() - o2.get("floorNo").asInt();
                            }
                        } else {
                            return new String(o1.get("orderAddress").asText()).compareTo(new String(o2.get("orderAddress").asText()));
                        }
                    }
                } else if ("tdr".equals(sortColumn)) {
                    if ("desc".equals(order)) {
                        return o2.get(sortColumn).asInt() - o1.get(sortColumn).asInt();
                    } else {
                        return o1.get(sortColumn).asInt() - o2.get(sortColumn).asInt();
                    }
                } else {
                    if ("desc".equals(order)) {
                        return new Double(o2.get(sortColumn).asDouble()).compareTo(new Double(o1.get(sortColumn).asDouble()));
                    } else {
                        return new Double(o1.get(sortColumn).asDouble()).compareTo(new Double(o2.get(sortColumn).asDouble()));
                    }
                }
            } else {
                /**
                 * @author kevin
                 * 默认排序
                 * 1、按地址中的小区单元楼排序 如俊丽苑B座
                 * 2、同小区同单元楼按楼层号排序
                 * 3、同楼层号：
                 * 				1、mtr正常的按门牌号排序
                 * 				2、mtr不正常的按mtr升序，mtr相同的按门牌号排序
                 */
                if ((o1.get("orderAddress").asText()).equals(o2.get("orderAddress").asText())) {
                    if (o1.get("floorNo").asInt() == (o2.get("floorNo").asInt())) {
                        if (o1.get("mtrStatus").asInt() == 1 && o2.get("mtrStatus").asInt() == 1) {
                            return o1.get("houseNo").asInt() - o2.get("houseNo").asInt();
                        } else {
                            if ((o1.get("mtr").asDouble()) == (o2.get("mtr").asDouble())) {
                                return o1.get("houseNo").asInt() - o2.get("houseNo").asInt();
                            } else {
                                return new Double(o1.get("mtr").asDouble()).compareTo(new Double(o2.get("mtr").asDouble()));
                            }
                        }
                    } else {
                        return o1.get("floorNo").asInt() - o2.get("floorNo").asInt();
                    }
                } else {
                    return new String(o1.get("orderAddress").asText()).compareTo(new String(o2.get("orderAddress").asText()));
                }
            }
        });
    }

}
