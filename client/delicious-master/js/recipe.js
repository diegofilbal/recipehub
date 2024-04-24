document.addEventListener('DOMContentLoaded', function() {
    var starIcon = document.getElementById('starIcon');

    starIcon.addEventListener('click', function() {
      // Alternar a classe 'selected'
      this.classList.toggle('selected');
    });
  });