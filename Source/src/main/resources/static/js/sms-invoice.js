$(function () {
  var dataTable = $('#id_invoice_list').DataTable({
    "scrollX": true,
    responsive: {
      details: false
    }
  });

  $(document).on('sidebarChanged', function () {
    dataTable.columns.adjust();
    dataTable.responsive.recalc();
    dataTable.responsive.rebuild();
  });
});

