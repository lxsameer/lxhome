(ns lxhome.views.home
  (:require [re-frame.core :as re-frame]))

(goog-define version "0.1.0")

(defn menu-button
  []
  [:div {:class "button naked huge"
         :on-click #(re-frame/dispatch [:toggle-menu])}
   [:i {:class :icon-th}]])


(defn link-button
  ([link text]
   (link-button link text nil))

  ([link text icon]

   [:a {:href link :class "button button-primary"}
    (if icon
      [:i {:class icon}])
    text]))

(defn cv-button
  []
  (link-button "//dl.lxsameer.com/CV/SameerRahmani.pdf" "Download My CV"))

(defn menu-items
  []
  [:section {:class "row menu"}
;;   [:div {:class :menu}]
   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "http://blog.lxsameer.com/"}
     [:i {:class :icon-rss}]
     "Blog"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "https://slides.com/lxsameer"}
     [:i {:class :icon-chat}]
     "Talks"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "#"}
     [:i {:class :icon-mic}]
     "Podcasts"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "#"}
     [:i {:class :icon-key}]
     "GPG Key"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "#"}
     [:i {:class :icon-phone}]
     "Contact"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "#"}
     [:i {:class :icon-vcard}]
     "About Me"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "#"}
     [:i {:class :icon-rss}]
     "Archive"]]

   [:span {:class :col-xs-4}
    [:a {:class "button default"
         :href "https://twitter.com/lxsameer"}
     [:i {:class :icon-twitter}]
     "Twitter"]]
   [:span {:class :col-xs-4}
    [:a {:class "button default"
         :href "https://github.com/lxsameer"}
     [:i {:class :icon-github}]
     "Github"]]
   [:span {:class :col-xs-4}
    [:a {:class "button default"
         :href "https://www.linkedin.com/in/lxsameer/"}
     [:i {:class :icon-linkedin}]
     "Linkedin"]]
   [:span {:class :col-xs-4}
    [:a {:class "button default"
         :href "https://medium.com/@lxsameer"}
     [:i {:class :icon-medium}]
     "Medium"]]
   [:span {:class :col-xs-4}
    [:a {:class "button default"
         :href "https://www.instagram.com/lxsameeer/"}
     [:i {:class :icon-instagram}]
     "Instagram"]]])

(defn header
  [menu]
  [:div {:class "row header"}
   [:div {:class "column"}
    [:nav
     [:a {:href "https://twitter.com/lxsameer"}
      [:i {:class "icon-twitter"}]]
     [:a {:href "https://github.com/lxsameer"}
      [:i {:class "icon-github"}]]
     ;; [:a {:on-click #(re-frame/dispatch [:toggle-menu])}
     ;;  [:i {:class "icon-th"}]]
     [:a {:href "https://www.linkedin.com/in/lxsameer/"}
      [:i {:class :icon-linkedin}]]
     [:a {:href "https://blog.lxsamer.com"}
      [:i {:class :icon-rss}]]]]])

(defn avatar
  [menu]
  [:section {:class :avatar-section}
   [:div {:class "row"}
    [:div {:class "column"}
     [:section {:class "title-header"}
      [:img {:src "images/me-1.jpg" :class :avatar :alt "Sameer Rahmani (@lxsameer) avatar"}]
      [:br]
      [:span {:class :no-wrap}
       ;;[menu-button]
       [:span {:class "title"} "Sameer" [:span {:class "last-name"} "Rahmani"]]]
      [:br]
      [:span {:class "subtitle"} "Senior Software Engineer"]]]]])

(defn cv
  [menu]
  [:div {:class "row"}
   [:div {:class "column"}
    [cv-button]]])

(defn footer
  []
  [:footer
   [:div {:class "row"}
    [:div {:class "column"}
     [:span {:class :copyright} (str "© 2010-2018 Sameer Rahmani - " version)]]]])

(defn more-info
  []
  [:ul {:class "social-links"}
   [:li
    [:a {:href "/"}
     [:i {:class :icon-key}]
     "My GPG Public Key"]
    [:br]
    [:span "Finger print:  05C63462DD0677B5"]]
   [:li
    [:a {:href "/"}
     [:i {:class :icon-instagram}]
     "Instagram"]]
   [:li
    [:a {:href "/" :class ""}
     [:i {:class :icon-mic}]
     "Podcasts"]]
   [:li
    [:a {:href "/" :class ""}
     [:i {:class :icon-vcard}]
     "Contact"]]])

(defn dropdown
  [menu]
  [:nav {:class (str "menu" (when menu " active"))}
   [more-info]])


(defn home-panel []
  (let [menu (re-frame/subscribe [:menu-state])]
    (fn []
      [:div
       ;;[dropdown @menu]
       [:section {:class "container"}
        [header @menu]
        [:section {:class (str "card" (when @menu " active"))}
         [avatar @menu]
         [:br]
         [cv     @menu]]

        [:br]
        [footer @menu]]])))
