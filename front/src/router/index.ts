import Vue from "vue";
import VueRouter, { RouteConfig } from "vue-router";
import Home from "../views/Main.vue";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
  {
    path: "/",
    name: "main",
    component: () =>
      import(/* webpackChunkName: "main" */ "../views/Main.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
