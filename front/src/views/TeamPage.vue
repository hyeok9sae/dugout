<template>
	<section>
		<p class="team-text"># 롯데자이언츠</p>
		<div class="temp">
			<ArticleCard></ArticleCard>
			<ArticleCard></ArticleCard>
		</div>
	</section>
</template>

<script>
import ArticleCard from '@/components/ArticleCard.vue';

export default {
	components: {
		ArticleCard,
	},
};
</script>

<style lang="scss" scoped>
@font-face {
	font-family: 'GongGothicMedium';
	src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10@1.0/GongGothicMedium.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
.temp {
	display: flex;
}
.team-text {
	font-family: 'GongGothicMedium';
	font-size: 1.5rem;
}
</style>
