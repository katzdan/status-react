(ns status-im.ui.screens.routing.screens
  (:require [status-im.extensions.module :as extensions.module]
            [status-im.ui.screens.about-app.views :as about-app]
            [status-im.ui.screens.accounts.create.views :as accounts.create]
            [status-im.ui.screens.accounts.login.views :as login]
            [status-im.ui.screens.accounts.recover.views :as recover]
            [status-im.ui.screens.accounts.views :as accounts]
            [status-im.ui.screens.add-new.new-chat.views :as new-chat]
            [status-im.ui.screens.add-new.new-public-chat.view :as new-public-chat]
            [status-im.ui.screens.add-new.views :as add-new]
            [status-im.ui.screens.bootnodes-settings.edit-bootnode.views
             :as
             edit-bootnode]
            [status-im.ui.screens.bootnodes-settings.views :as bootnodes-settings]
            [status-im.ui.screens.browser.open-dapp.views :as open-dapp]
            [status-im.ui.screens.browser.views :as browser]
            [status-im.ui.screens.chat.views :as chat]
            [status-im.ui.screens.contacts-list.views :as contacts-list]
            [status-im.ui.screens.currency-settings.views :as currency-settings]
            [status-im.ui.screens.dapps-permissions.views :as dapps-permissions]
            [status-im.ui.screens.fleet-settings.views :as fleet-settings]
            [status-im.ui.screens.group.views :as group]
            [status-im.ui.screens.hardwallet.authentication-method.views
             :as
             hardwallet.authentication]
            [status-im.ui.screens.hardwallet.connect.views :as hardwallet.connect]
            [status-im.ui.screens.hardwallet.pin.views :as hardwallet.pin]
            [status-im.ui.screens.hardwallet.settings.views :as hardwallet.settings]
            [status-im.ui.screens.hardwallet.setup.views :as hardwallet.setup]
            [status-im.ui.screens.hardwallet.success.views :as hardwallet.success]
            [status-im.ui.screens.help-center.views :as help-center]
            [status-im.ui.screens.home.views :as home]
            [status-im.ui.screens.intro.views :as intro]
            [status-im.ui.screens.log-level-settings.views :as log-level-settings]
            [status-im.ui.screens.mobile-network-settings.view
             :as
             mobile-network-settings]
            [status-im.network.module :as network]
            [status-im.ui.screens.offline-messaging-settings.edit-mailserver.views
             :as
             edit-mailserver]
            [status-im.ui.screens.offline-messaging-settings.views
             :as
             offline-messaging-settings]
            [status-im.ui.screens.pairing.views :as pairing]
            [status-im.ui.screens.profile.contact.views :as profile.contact]
            [status-im.ui.screens.profile.group-chat.views :as profile.group-chat]
            [status-im.ui.screens.profile.photo-capture.views :as photo-capture]
            [status-im.ui.screens.profile.seed.views :as profile.seed]
            [status-im.ui.screens.profile.tribute-to-talk.views :as tr-to-talk]
            [status-im.ui.screens.profile.user.views :as profile.user]
            [status-im.ui.screens.progress.views :as progress]
            [status-im.ui.screens.qr-scanner.views :as qr-scanner]
            [status-im.ui.screens.stickers.views :as stickers]
            [status-im.ui.screens.wallet.collectibles.views :as collectibles]
            [status-im.ui.screens.wallet.components.views :as wallet.components]
            [status-im.ui.screens.wallet.main.views :as wallet.main]
            [status-im.ui.screens.wallet.onboarding.views :as wallet.onboarding]
            [status-im.ui.screens.wallet.request.views :as request]
            [status-im.ui.screens.wallet.send.views :as send]
            [status-im.ui.screens.wallet.settings.views :as wallet-settings]
            [status-im.ui.screens.wallet.transactions.views :as wallet-transactions]
            [status-im.ui.screens.wallet.custom-tokens.views :as custom-tokens]))

(def all-screens
  {:login                            login/login
   :progress                         progress/progress
   :create-account                   accounts.create/create-account
   :recover                          recover/recover
   :accounts                         accounts/accounts
   :intro                            intro/intro
   :hardwallet-authentication-method hardwallet.authentication/hardwallet-authentication-method
   :hardwallet-connect               hardwallet.connect/hardwallet-connect
   :hardwallet-connect-settings      hardwallet.connect/hardwallet-connect
   :hardwallet-connect-sign          hardwallet.connect/hardwallet-connect
   :hardwallet-connect-modal         [:modal hardwallet.connect/hardwallet-connect]
   :enter-pin-login                  hardwallet.pin/enter-pin
   :enter-pin-settings               hardwallet.pin/enter-pin
   :enter-pin-sign                   hardwallet.pin/enter-pin
   :enter-pin-modal                  [:modal hardwallet.pin/enter-pin]
   :hardwallet-setup                 hardwallet.setup/hardwallet-setup
   :hardwallet-success               hardwallet.success/hardwallet-success
   :home                             home/home-wrapper
   :chat                             chat/chat
   :profile                          profile.contact/profile
   :new                              add-new/add-new
   :new-chat                         new-chat/new-chat
   :qr-scanner                       qr-scanner/qr-scanner
   :profile-qr-viewer                [:modal profile.user/qr-viewer]
   :take-picture                     extensions.module/take-picture-view
   :extension-screen-holder          extensions.module/screen-holder-view
   :new-group                        group/new-group
   :add-participants-toggle-list     group/add-participants-toggle-list
   :contact-toggle-list              group/contact-toggle-list
   :group-chat-profile               profile.group-chat/group-chat-profile
   :new-public-chat                  new-public-chat/new-public-chat
   :open-dapp                        open-dapp/open-dapp
   :browser                          browser/browser
   :stickers                         stickers/packs
   :stickers-pack                    stickers/pack
   :stickers-pack-modal              [:modal stickers/pack-modal]
   :tribute-learn-more               [:modal tr-to-talk/learn-more]
   :chat-modal                       [:modal chat/chat-modal]
   :show-extension-modal             [:modal extensions.module/show-extension-modal-view]
   :wallet-onboarding-setup-modal    [:modal wallet.onboarding/modal]
   :wallet                           wallet.main/wallet
   :collectibles-list                collectibles/collectibles-list
   :wallet-onboarding-setup          wallet.onboarding/screen
   :contact-code                     wallet.components/contact-code
   :wallet-send-transaction          send/send-transaction
   :recent-recipients                wallet.components/recent-recipients
   :recipient-qr-code                wallet.components/recipient-qr-code
   :wallet-send-assets               wallet.components/send-assets
   :wallet-request-transaction       request/request-transaction
   :wallet-send-transaction-request  request/send-transaction-request
   :wallet-request-assets            wallet.components/request-assets
   :unsigned-transactions            wallet-transactions/transactions
   :transactions-history             wallet-transactions/transactions
   :wallet-transaction-details       wallet-transactions/transaction-details
   :wallet-settings-hook             wallet-settings/settings-hook
   :selection-modal-screen           [:modal extensions.module/selection-modal-screen-view]
   :wallet-settings-assets           wallet-settings/manage-assets
   :wallet-add-custom-token          custom-tokens/add-custom-token
   :wallet-custom-token-details      custom-tokens/custom-token-details
   :wallet-transactions-filter       [:modal wallet-transactions/filter-history]
   :my-profile                       profile.user/my-profile
   :my-profile-ext-settings          profile.user/extensions-settings
   :contacts-list                    contacts-list/contacts-list
   :blocked-users-list               contacts-list/blocked-users-list
   :profile-photo-capture            photo-capture/profile-photo-capture
   :about-app                        about-app/about-app
   :bootnodes-settings               bootnodes-settings/bootnodes-settings
   :installations                    pairing/installations
   :edit-bootnode                    edit-bootnode/edit-bootnode
   :offline-messaging-settings       offline-messaging-settings/offline-messaging-settings
   :edit-mailserver                  edit-mailserver/edit-mailserver
   :help-center                      help-center/help-center
   :dapps-permissions                dapps-permissions/dapps-permissions
   :manage-dapps-permissions         dapps-permissions/manage
   :extensions-settings              extensions.module/extensions-settings-view
   :edit-extension                   extensions.module/edit-extension-view
   :show-extension                   extensions.module/show-extension-view
   :network-settings                 network/network-settings-view
   :network-details                  network/network-details-view
   :edit-network                     network/edit-network-view
   :log-level-settings               log-level-settings/log-level-settings
   :fleet-settings                   fleet-settings/fleet-settings
   :currency-settings                currency-settings/currency-settings
   :backup-seed                      profile.seed/backup-seed
   :tribute-to-talk                  tr-to-talk/tribute-to-talk
   :reset-card                       hardwallet.settings/reset-card
   :keycard-settings                 hardwallet.settings/keycard-settings
   :mobile-network-settings          mobile-network-settings/mobile-network-settings
   :welcome                          [:modal home/welcome]})

(defn get-screen [screen]
  (get all-screens screen #(throw (str "Screen " screen " is not defined."))))
