<template>

  My app
  <Headers>
    <div class="container">
      <Balance></Balance>
      <IncomeExpenses></IncomeExpenses>
      <TransactionListVue></TransactionListVue>
    </div>
  </Headers>
</template>

<script>

  import Headers from './components/Header.vue'
  import Balance from './components/Balance.vue'
  import IncomeExpenses from './components/IncomeExpense.vue'
  import TransactionListVue from './components/TransactionList.vue'
  import AddTransactionalVue from './components/AddTransactional.vue'
  export default {
    components:{
      Headers,Balance,IncomeExpenses,TransactionListVue,AddTransactionalVue
    }
  }

</script>